package lesson7.homework;

interface eat{
    int eat(MyObject subject);
}
public abstract class Animal implements eat{
    int hunger = 0;
    String type = "Animnal";
    String name = "name";

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public int eat(MyObject subject){
        if (subject.getFood() >= hunger) {
            subject.setFood(subject.getFood()-hunger);
            hunger = 0;
        }
        return hunger;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        hunger = hunger;
    }
}
