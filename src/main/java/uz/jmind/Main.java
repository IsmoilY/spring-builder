package uz.jmind;

import java.util.HashMap;
import java.util.Map;

public class Main {

    //supported deprecated on methods, but only with CGLIB proxies
    public static void main(String[] args) {
        ApplicationContext context = Application.run("uz.jmind", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
        CoronaDesinfector desinfector = context.getObject(CoronaDesinfector.class);
        desinfector.start(new Room());
    }

}
