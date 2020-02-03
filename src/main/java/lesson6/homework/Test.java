package lesson6.homework;

public class Test {


    public static void main(String[] args) {
        Animals Musia = new Cat("cat", "Musia");
        Animals Shania = new Dog("dog", "Shania");
        System.out.println(Musia.name +" is "+Musia.type);
        System.out.println(Shania.name+" is "+Shania.type);
        System.out.println("============ run =====================");
        System.out.println("Musia run 100?");
        System.out.println("Musia run 100 is "+Musia.run(100));
        System.out.println("Shania run 100?");
        System.out.println("Shania run 100 is "+Shania.run(100));
        System.out.println("Musia run 300?");
        System.out.println("Musia run 300 is "+Musia.run(300));
        System.out.println("Shania run 300?");
        System.out.println("Shania run 300 is "+Shania.run(300));
        System.out.println("Shania run 800?");
        System.out.println("Shania run 800 is "+Shania.run(800));
        System.out.println("============ jump =====================");
        System.out.println("Shania jump 0.5?");
        System.out.println("Shania jump 0.5 is "+Shania.jump(0.5));
        System.out.println("Musia jump 0.5?");
        System.out.println("Musia jump 0.5 is "+Musia.jump(0.5));
        System.out.println("Shania jump 1?");
        System.out.println("Shania jump 1 is "+Shania.jump(1));
        System.out.println("Musia jump 1?");
        System.out.println("Musia jump 1 is "+Musia.jump(1));
        System.out.println("Musia jump 2.1?");
        System.out.println("Musia jump 2.1 is "+Musia.jump(2.1));
        System.out.println("============ swim =====================");
        System.out.println("Shania swim 1?");
        System.out.println("Shania swim 1 is "+Shania.swim(1));
        System.out.println("Musia swim 1?");
        System.out.println("Musia swim 1 is "+Musia.swim(1));
        System.out.println("Shania swim 10.5?");
        System.out.println("Shania swim 10.5 is "+Shania.swim(10.5));
        System.out.println("========================================");

    }
}
