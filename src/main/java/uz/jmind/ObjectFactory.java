package uz.jmind;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectFactory {

    private static final ObjectFactory INSTANCE = new ObjectFactory();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Config config;

    @SneakyThrows
    private ObjectFactory() {
        config = new JavaConfig("uz.jmind", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
        for (Class<? extends ObjectConfigurator> aClass : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    public static ObjectFactory getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> impl = type;
        if (type.isInterface()) {
            impl = config.getImplClass(type);
        }
        T t = impl.getDeclaredConstructor().newInstance();
        configurators.forEach(configurator -> configurator.configure(t));
        return t;
    }
}
