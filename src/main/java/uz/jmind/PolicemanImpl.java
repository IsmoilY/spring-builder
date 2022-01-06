package uz.jmind;

@Singleton
public class PolicemanImpl implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Police!!! Go out...");
    }
}
