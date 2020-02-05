package lesson7.homework;

import java.util.Random;

public class Cat extends Animal{
    boolean isNotHunger;
    public Cat(String type, String name) {
        super(type, name);
        hunger = Math.abs(new Random().nextInt(100));
        isNotHunger = false;
    }

    @Override
    public String toString() {
        return "Animal " + type + " " + name + " is hunger at " + hunger + " e.d. It`s "+(isNotHunger == true ? " not ":"" )+" hunger." ;
    }

    @Override
    public int eat(MyObject subject) {
        if (super.eat(subject) == 0) { isNotHunger = true;}
        return hunger;
    }
}
