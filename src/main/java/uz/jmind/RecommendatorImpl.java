package uz.jmind;

public class RecommendatorImpl implements Recommendator {

    @InjectProperty("wisky")
    private String drink;

    @Override
    public void recommend() {
        System.out.println("Drink **" + drink + "** to get over from covid-2019");
    }
}
