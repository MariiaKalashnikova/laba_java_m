package org.fpm.di.example;
import org.fpm.di.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Tests {
    private Container container;

    private BinderImplement binder;

    @Before
    public void setUp() {
        Environment env = new EnvironmentImplement();
        binder = new BinderImplement(new HashMap<>(), new HashMap<>());
        container = env.configure(new MyConfiguration());
    }
    @Test
    public void test1() {
        System.out.println(container.getComponent(A.class));
        System.out.println(container.getComponent(B.class));
        //клас В наслідується від класу А, отже, результати мають бути однаковими
    }

    /*@Test(expected = ContainerExc.class)
    public void testCyclicDependency() {
        Map<Class<?>, Class<?>> implementOfMap = new HashMap<>();
        implementOfMap.put(F.class, E.class);
        implementOfMap.put(E.class, D.class);
        implementOfMap.put(D.class, F.class);

        Container container = new ContainerImplement(implementOfMap, new HashMap<>());

        container.getComponent(F.class);
    }*/

    @Test
    public void test2() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
        assertSame(hasADependency.getDependency(), container.getComponent(A.class));
        assertNotSame(hasADependency.getDependency(), container.getComponent(MyPrototype.class));
        System.out.println(hasADependency.getDependency());
        System.out.println(container.getComponent(A.class));
        System.out.println(container.getComponent(B.class));
        System.out.println(container.getComponent(MyPrototype.class));

    }

    @Test
    public void test3() {
        System.out.println(container.getComponent(A.class));
        System.out.println(container.getComponent(B.class));
    }

    @Test
    public void test4() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test(expected = NullPointerException.class)
    public void nullExc() {
        binder.bind(null);
    }

    @Test(expected = BinderExc.class)
    public void abstractClass() {
        binder.bind(T.class);
    }

    @Test(expected = BinderExc.class)
    public void interfaceClass() {
        binder.bind(T1.class);
    }

    @Test
    public void test5() {
        System.out.println(container.getComponent(A.class));
        System.out.println(container.getComponent(A.class));
        System.out.println(container.getComponent(B.class));
        System.out.println(container.getComponent(B.class));
    }

    @Test
    public void shouldInjectSingleton() {
        System.out.println(container.getComponent(MySingleton.class));
        System.out.println(container.getComponent(MySingleton.class));
        System.out.println("--------------");
        System.out.println(container.getComponent(MyPrototype.class));
        System.out.println(container.getComponent(MyPrototype.class));
    }

}
