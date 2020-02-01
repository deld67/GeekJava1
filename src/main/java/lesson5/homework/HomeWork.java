package lesson5.homework;

import java.util.ArrayList;
import java.util.Random;

public class HomeWork {

     static class Person {
        // TODO: 28.01.2020
        //ФИО, должность, email, телефон, зарплата, возраст;
        String name;
        String cast;
        String email;
        String phone;
        double cash;
        int age;

        public Person(){}

        public Person(String name, String cast, String email, String phone, double cash, int age) {
            this.name = name;
            this.cast = cast;
            this.email = email;
            this.phone = phone;
            this.cash  = cash;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", cast='" + cast + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", cash=" + cash +
                    ", age=" + age +
                    '}';
        }
    }

    public static Person [] createFivePerson() {
        // TODO: 28.01.2020
        String[] lastNames = new String[]{"Иванов","Петров","Сидоров","Кац","Рюмин"};
        String[] names = new String[]{"Петр","Иван","Александр","Алексей","Роман"};
        String[] middleNames = new String[]{"Иванович","Петрович","Генрихович","Владимирович","Сергеевич" };
        String[] casts = new String[]{"директор","менеджер","тестировщик","программист","технолог"};
        String[] emails = new String[]{"leader@mask.org","test@ip.ru","lasso@god.su","name@pisem.net",""};
        String[] phones = new String[]{"001","003","88001000101","102",""};
        Person[] fivePersons = new Person[5];

        for (int i = 0; i < fivePersons.length; i++) {
            fivePersons[i] = new Person(lastNames[new Random().nextInt(fivePersons.length-1)] +" "+
                        names[new Random().nextInt(fivePersons.length-1)]+" "+
                        middleNames[new Random().nextInt(fivePersons.length-1)],
                        casts[new Random().nextInt(fivePersons.length-1)],
                        emails[new Random().nextInt(fivePersons.length-1)],
                        phones[new Random().nextInt(fivePersons.length-1)],
                        new Random().nextInt(200000),
                        new Random().nextInt(60) );
        }
        for (Person pers: fivePersons){
            System.out.println(pers);
        }
        return fivePersons;
    }
    
    public static ArrayList<Person> filterBiggerThan40(Person[] people) {
         ArrayList<Person> ageesPersons = new ArrayList<>();
        // TODO: 28.01.2020
        for (int i = 0; i < people.length; i++) {
            if (people[i].age > 40) {
                ageesPersons.add(people[i]);
            }
        }

        return ageesPersons;
    }

    public static void main(String[] args) {
        Person[] P = HomeWork.createFivePerson();
        System.out.println("=================persons over 40===========================");
        ArrayList<Person> listPerson = HomeWork.filterBiggerThan40(P);
        for (int i = 0; i < listPerson.size(); i++) {
            System.out.println(listPerson.get(i).toString());
        }



    }
}
