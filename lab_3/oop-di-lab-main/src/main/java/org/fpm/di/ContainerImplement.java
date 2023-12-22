package org.fpm.di;
import java.lang.reflect.Constructor;
import java.util.*;

import javax.inject.Inject;
import javax.inject.Singleton;

public class ContainerImplement implements Container{

    private final Map<Class<?>, Class<?>> implementOfMap; //мапа клас - реалізація

    private final Map<Class<?>, Object> instanceOfMap; //мапа клас - екземпляр

    //змінні для відслідковування циклічних залежностей (P.S. закоментувала, бо на останньому занятті це не перевірялося)
    private final Map<Class<?>, Boolean> visitedClasses = new HashMap<>(); //відвідувані класи
    private final Deque<Class<?>> currentPath = new ArrayDeque<>(); //поточний клас


    public ContainerImplement(Map<Class<?>, Class<?>> implementOfMap, Map<Class<?>, Object> instanceOfMap) {
        this.implementOfMap = implementOfMap;
        this.instanceOfMap = instanceOfMap;
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (instanceOfMap.containsKey(clazz)) {
            //перевірка, якщо переданий клас пов'язан з екземпляром
            return (T) instanceOfMap.get(clazz);
        }
        else if (implementOfMap.containsKey(clazz)){
            //перевірка, якщо переданий клас пов'язан з реалізацією
            // Отримання реалізації класу
            Class<T> clazz_n = (Class<T>) implementOfMap.get(clazz);
            if (!clazz_n.equals(clazz) && (implementOfMap.containsKey(clazz_n) || instanceOfMap.containsKey(clazz_n))){
                /*if (isCyclicDependency(clazz)) {
                //якщо виявлена циклічна залежність
                    throw new ContainerExc("There is a cycle in injection");
                }*/
                currentPath.push(clazz);
                //
                return getComponent(clazz_n);
            }
            return getInstance(clazz_n);
        }
        return null;
    }
    //метод для виявлення циклічної залежності
    /*private <T> boolean isCyclicDependency(Class<T> clazz) {
        if (visitedClasses.containsKey(clazz)) {
            // перевірка, чи клас вже був відвіданий
            return true;
        }
        // відмічаємо клас, як відвіданий
        visitedClasses.put(clazz, true);
        // перевірка наявності циклічності в поточному шляху
        for (Class<?> visitedClass : currentPath) {
            if (visitedClass.equals(clazz)) {
                return true;
            }
        }
        return false;
    }*/
    private <T> T getInstance(Class<T> clazz) {
        T instance = null;
        try {
            //створення екземпляра класу
            instance = this.creationInstance(clazz);
            if (clazz.getAnnotation(Singleton.class) != null) {
                //якщо клас позначено анотацією @Singleton, то кладемо цю реалізацію (вона буде 1, не можна щоб ще створювалися реалізації)
                this.instanceOfMap.put(clazz, instance);
            }
        } catch (Exception e) {
            //помилка під час методу getInstance()
            throw new ContainerExc("Error in getInstance");
        } finally {
            //видалення класу зі списку відвіданих
            visitedClasses.remove(clazz);
        }
        return instance;
    }

    private <T> T creationInstance(Class<T> clazz) {
        try {
            // отримання всіх конструкторів класу
            Constructor<?>[] allConstructors = clazz.getDeclaredConstructors();
            for (int i = 0; i < allConstructors.length; i++) {
                //Шияк Б. казав, що inject має працювати на конструкторах, перевірка, чи певний конструктор має анотацію відповідну
                if (allConstructors[i].isAnnotationPresent(Inject.class)) {
                    // типи параметрів конструктора
                    Class<?>[] types = allConstructors[i].getParameterTypes();
                    // масив для зберігання значень параметрів конструктора
                    Object[] argumentsMas = new Object[types.length];
                    /*if (isCyclicDependency(clazz)) {
                    //якщо виявлена циклічна залежність
                        throw new ContainerExc("There is a cycle in injection");
                    }*/

                    // заповнення масиву значеннями залежностей
                    for (int k = 0; k < types.length; k++) {
                        argumentsMas[k] = this.getComponent(types[k]);
                    }

                    // налаштування доступу до конструктора та створення екземпляра
                    allConstructors[i].setAccessible(true);
                    return (T) allConstructors[i].newInstance(argumentsMas);
                }
            }
            //якщо немає конструктора з анотацією @Inject, створюємо екземпляр за звичайним конструктором
            Constructor<T> constructor_1 = clazz.getDeclaredConstructor(); //отримаємо звичайний конструктор
            constructor_1.setAccessible(true); //встановлюємо доступ (якщо він приватний чи захищений, щоб траблів не було)
            return constructor_1.newInstance();
        }
        catch (Exception e) {
            //якщо виникли помилки
            throw new ContainerExc("Error in creationInstance");
        }

    }

}

