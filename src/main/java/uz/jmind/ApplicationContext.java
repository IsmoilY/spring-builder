package uz.jmind;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    @Setter
    private ObjectFactory objectFactory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();
    @Getter
    private Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type) {
        Class<? extends T> impl = type;

        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        if (type.isInterface()) {
            impl = config.getImplClass(type);
        }

        T t = objectFactory.createObject(impl);

        if (impl.isAnnotationPresent(Singleton.class)) {
            cache.put(type, t);
        }

        return t;
    }

}
