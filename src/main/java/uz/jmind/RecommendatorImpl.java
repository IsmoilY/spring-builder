package uz.jmind;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("wisky")
    private String drink;

    /**
     * Just to see, how many times does this object is being created
     */
    public RecommendatorImpl() {
        System.out.println("RecommendatorImpl is being created");
    }

    @Override
    public void recommend() {
        System.out.println("Drink **" + drink + "** to get over from covid-2019");
    }

}
