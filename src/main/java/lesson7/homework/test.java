package lesson7.homework;

import java.util.Random;

public class test {
    final static int cnt_cats = 10;


    private static void  initCats(Cat[] cats){
        for (int i = 0; i < cnt_cats; i++) {
            cats[i] = new Cat("Cat", "Cat"+(i+1));
        }
    }
    private static void  eating(Cat[] cats, Plate plate){
        for (int i = 0; i < cats.length; i++) {
            if (!cats[i].isNotHunger){
                System.out.println(cats[i].getType()+ ""+ cats[i].getName()+" come to "+plate.name+" and eat");
                cats[i].eat(plate);
            }
        }
    }
    private static void statesOfCats(Cat[] cats){
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
        if (fndHungryCat(cats)){
            System.out.println("One or many cats is hungry. Feeding it.");
        } else {
            System.out.println("All cats is not hungry.");
        }
    }

    private static boolean fndHungryCat (Cat[] cats){
        for(Cat cat: cats){
            if (!cat.isNotHunger) return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        Cat[] cats = new Cat[cnt_cats];
        int i = 0;
        initCats(cats);
        Plate plate = new Plate("plate", "plate1");
        while (fndHungryCat(cats)) {
            eating(cats, plate);
            i++;
            System.out.println("===================== After "+i+" eating ====================================");
            statesOfCats(cats);
            if (fndHungryCat(cats)) {
                System.out.println("+++++++++++ add food +++++++++++++++++");
                System.out.println(plate);
                System.out.println("Add food in to " + plate.type + " " + plate.name);
                plate.setFood(plate.getFood() + new Random().nextInt(10));
                System.out.println("Now. " + plate);
            }

        }

    }



}
