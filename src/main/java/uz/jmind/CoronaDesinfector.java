package uz.jmind;

public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room) {
        //notify everyone about desinfection and ask to leave
        announcer.announce("Desinfection is about to start, please leave the room");
        //force them to leave
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        //notify everyone that they can return
        announcer.announce("Desinfection finished, you can return to the room");
    }

    private void desinfect(Room room) {
        System.out.println("Room is : " + room + " being desinfected with ISIRIQ");
        System.out.println("Room has been " + room + " desinfected!!!. NO COVID ANYMORE!!!");
    }

}
