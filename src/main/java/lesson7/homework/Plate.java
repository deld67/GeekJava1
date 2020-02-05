package lesson7.homework;

import java.util.Random;

public class Plate extends MyObject {
    public Plate(String type, String name) {
        super(type, name);
        foot = Math.abs(new Random().nextInt(500));
    }

    @Override
    public String toString() {
        return "Object " + type + " " + name + " made "+ foot +" foots.";
    }
}
