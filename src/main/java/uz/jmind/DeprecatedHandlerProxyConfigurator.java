package uz.jmind;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if (Arrays.stream(implClass.getMethods()).anyMatch(method -> method.isAnnotationPresent(Deprecated.class))) {
            return Enhancer.create(
                    implClass, implClass.getInterfaces(),
                    (InvocationHandler) (o, method, args) -> method.isAnnotationPresent(Deprecated.class) ? getInvocationHandleLogic(t, method, args) : method.invoke(t, args)
            );
        } else {
            return t;
        }
    }

    private Object getInvocationHandleLogic(Object t, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println("*************** " + method.getDeclaringClass().getName() + "::" + method.getName() + " is deprecated ***************");
        return method.invoke(t, args);
    }
}
