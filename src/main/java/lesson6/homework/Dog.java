package lesson6.homework;

public class Dog extends Animals {
    public Dog(String type) {
        super(type);
    }

    //(бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.`
    @Override
    public boolean run(double len) {
        MaxLen = 500;
        return  super.run(len);
    }

    @Override
    public boolean swim(double len) {
        MaxLen = 10;
        return super.swim(len);
    }

    @Override
    public boolean jump(double len) {
        MaxLen = 0.5;
        return super.jump(len);
    }
}
