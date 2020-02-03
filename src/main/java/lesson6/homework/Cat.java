package lesson6.homework;

public class Cat extends Animals {
    public Cat(String type, String name) {
        super(type, name);
    }

    //(бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.
    @Override
    public boolean run(double len) {
        MaxLen = 200;
        return super.run(len);
    }

    @Override
    public boolean swim(double len) {
        MaxLen = 0;
        return  super.swim(len);
    }

    @Override
    public boolean jump(double len) {
        MaxLen = 2;
        return super.jump(len);
    }
}
