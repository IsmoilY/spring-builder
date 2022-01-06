package uz.jmind;

import javax.annotation.PostConstruct;

@Singleton
public class AngryPoliceman implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    // throws NPE because recommendator is not injected while object is being created
//    public AngryPoliceman() {
//        System.out.println(recommendator.getClass());
//    }

    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Angry policeman is shouting at everyone. LEAVE THE ROOM!!!");
    }
}
