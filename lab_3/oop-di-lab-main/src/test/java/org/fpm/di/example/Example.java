package org.fpm.di.example;

import org.fpm.di.*;
import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    private BinderImplement binder;

    @Before
    public void setUp() {
        Environment env = new EnvironmentImplement();
        binder = new BinderImplement(new HashMap<>(), new HashMap<>());
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());

        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }
}
