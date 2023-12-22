package org.fpm.di;

import java.util.*;
import java.lang.reflect.Modifier;


public class BinderImplement implements Binder{
    private final Map<Class<?>, Class<?>> implementOfMap; //мапа клас - реалізація
    private final Map<Class<?>, Object> instanceOfMap; //мапа клас - екземпляр


    public BinderImplement(Map<Class<?>, Class<?>> implementOfMap, Map<Class<?>, Object> instanceOfMap) {
        this.implementOfMap = implementOfMap;
        this.instanceOfMap = instanceOfMap;
    }

    @Override
    public <T> void bind(Class<T> clazz){
        Objects.requireNonNull(clazz, "clazz == null"); //якщо передався null, то помилка
        bind(clazz, clazz); //встановлення залежності класу з самим собою
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        //перевірка, чи клас та реалізація не є null
        Objects.requireNonNull(clazz, "clazz == null");
        Objects.requireNonNull(implementation, "implementation == null");

        if (Modifier.isAbstract(implementation.getModifiers()) || implementation.isInterface()) {
            //не можна зв'язувати інтерфейси та абстрактні класи як реалізацію
            throw new BinderExc("Abstract or interface");
        }

        if (implementOfMap.containsKey(clazz) || instanceOfMap.containsKey(clazz)){
            //якщо клас вже пов'язаний з реалізацією або екземпляром
            throw new BinderExc("Зв'язок вже існує");
        }

        //зв'язування класу з його реалізацією
        implementOfMap.put(clazz, implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        //перевірка, чи клас та екземпляр не є null
        Objects.requireNonNull(clazz, "clazz == null");
        Objects.requireNonNull(instance, "instance == null");
        if (implementOfMap.containsKey(clazz) || instanceOfMap.containsKey(clazz)){
            //чи не пов'язаний ще клас
            throw new BinderExc("Зв'язок вже існує");
        }
        //зв'язування класу з його екземпляром
        instanceOfMap.put(clazz, instance);

    }

}
