package org.fpm.di.example;

import javax.inject.Inject;

public class UseA {
    private final A dependency;
    private final B b;

    private final MyPrototype prototype;

    @Inject
    public UseA(A a, B b, MyPrototype prototype) {
        this.dependency = a;
        this.b = b;
        this.prototype=prototype;
    }

    public A getDependency() {
        return dependency;
    }
    public B getB() {
        return b;
    }
}


