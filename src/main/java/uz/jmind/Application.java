package uz.jmind;

import java.util.Map;

public class Application {

    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        JavaConfig config = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory factory = new ObjectFactory(context);
        //todo : homework - init all singletons which are not lazy
        context.setObjectFactory(factory);
        return context;
    }

}
