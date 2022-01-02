package uz.jmind;

public class ConsoleAnnouncer implements Announcer {

    /**
     * if ObjectFactory.getInstance().createObject(Recommendator.class) is called again anywhere
     * then new instance will be created
     */
    private Recommendator recommendator = ObjectFactory.getInstance().createObject(Recommendator.class);

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
