package org.fpm.di;
import java.util.HashMap;
import java.util.Map;

public class EnvironmentImplement implements Environment{
    private final Map<Class<?>, Class<?>> implementOfMap;
    private final Map<Class<?>, Object> instanceOfMap;

    public EnvironmentImplement(){
        this.implementOfMap = new HashMap<>();
        this.instanceOfMap = new HashMap<>();
    }


    @Override
    public Container configure(Configuration configuration) {
        // створення екземпляра для здійснення зв'язування класів
        Binder binder = new BinderImplement(implementOfMap, instanceOfMap);

        configuration.configure(binder);

        // налаштування реалізації контейнера зі зв'язаними класами та їхніми екземплярами
        Container container_conf = new ContainerImplement(implementOfMap, instanceOfMap);
        return container_conf;
    }
}
