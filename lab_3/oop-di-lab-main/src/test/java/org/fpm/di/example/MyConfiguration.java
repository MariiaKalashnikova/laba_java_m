package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);
        //binder.bind(A.class); //щоразу клас новий
        binder.bind(A.class, B.class);

        //binder.bind(B.class); //щоразу клас В новий
        binder.bind(B.class, new B()); //щоразу буде викликатися однаковий клас В, бо створення через конструктор
    }
}
