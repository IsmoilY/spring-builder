package uz.jmind;

import org.reflections.Reflections;

public interface Config {

    public <T> Class<? extends T> getImplClass(Class<T> ifc);

    Reflections getScanner();

}
