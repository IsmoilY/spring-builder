package uz.jmind;

import java.util.Random;

public class Room {

    private String number;

    public Room() {
        this.number = new Random().nextInt(100) + "";
    }

    @Override
    public String toString() {
        return "Room{" +
                "number='" + number + '\'' +
                '}';
    }
}
