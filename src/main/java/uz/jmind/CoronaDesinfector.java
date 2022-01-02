package uz.jmind;

public class CoronaDesinfector {

    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

    public void start(Room room) {
        //todo : notify everyone about desinfection and ask to leave
        announcer.announce("Desinfection is about to start, please leave the room");
        //todo : force them to leave
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        //todo : notify everyone that they can return
        announcer.announce("Desinfection finished, you can return to the room");
    }

    private void desinfect(Room room) {
        System.out.println("Room is : " + room + " being desinfected with ISIRIQ");
        System.out.println("Room has been " + room + " desinfected!!!. NO COVID ANYMORE!!!");
    }

}