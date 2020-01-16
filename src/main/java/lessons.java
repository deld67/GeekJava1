public class lessons {
/* Тарасов Сергей. Домашнее задание № 1*/
    static double calculate(double a, double b, double c, double d) {
        return  a* (b+c/d);
    }

    static void printResSum10_20(boolean result, double a, double b ){
        if (result) {
            System.out.println("Сумма чисел "+a+" и "+b+" входит в интевал (10;20]");
        }else{
            System.out.println("Сумма чисел "+a+" и "+b+" не входит в интевал (10;20]");
        }
    }
    static boolean checkSum10_20(double a, double b){
        return (a+b) > 10 && (a+b) <= 20.00 ? true: false;
    }

    static void printCheckSingNum( int a){
        System.out.println("Число "+a+" "+ (a >= 0 ? "положительное":"отрицательное")+".");
    }

    static boolean checkSingNum( double a){
        if (10*a % 10  == 0) {
            return true;
        }
        return false;
    }

    static  void  prChSingNum(boolean result, double a){
        System.out.println("Число "+a+" "+(result == true ? "целое":"дробное")+" ("+result+")." );
    }


    static  void  prHello(String name){
        if (name.trim().length() == 0){
            System.out.println("Привет, <<неизвестный>>!");
        }else{
            System.out.println("Привет, "+name.trim());
        }
    }
    static void checkYear(int Year){
        if (Year % 400 == 0){
            System.out.println("Год "+Year+" високосный.");
        }else if (Year % 100 == 0){
            System.out.println("Год "+Year+" не високосный.");
        }else if (Year % 4 == 0){
            System.out.println("Год "+Year+" високосный.");
        }else{
            System.out.println("Год "+Year+" не високосный.");
        }

    }
    public static void main(String[] args) {
        byte varByte        = 1;
        short varSort       = 10;
        int varInt          = 100;
        long varLong        = 1000;
        float varFloat      = 10000.00f;
        double varDouble    = 100000.99;
        char varChar        = 'A';
        boolean varBoolean  = true;

        double a = 10;
        double b = 20;
        double c = 31;
        double d = 5;
        System.out.println("======================= Задание 3 =================================");
        System.out.println(a+"*("+b+"+("+c+"/"+d+")) ="+calculate(a,b,c,d) );
        System.out.println("======================= Задание 4 =================================");
        System.out.println("Проверка суммы двух чисел на вхождение в интервал (10;20]");
        printResSum10_20(checkSum10_20(10,5), 10, 5);
        printResSum10_20(checkSum10_20(10,10.2), 10, 10.2);
        printResSum10_20(checkSum10_20(5,3.33), 5, 3.33);
        printResSum10_20(checkSum10_20(10,10), 10, 10);
        System.out.println("======================= Задание 5 =================================");
        printCheckSingNum(-1);
        printCheckSingNum(0);
        printCheckSingNum(1);
        printCheckSingNum(1000);
        printCheckSingNum(-34562);
        System.out.println("=======================Задание 6 =================================");
        prChSingNum(checkSingNum(10.45), 10.45);
        prChSingNum(checkSingNum(100), 100);
        prChSingNum(checkSingNum(0), 0);
        prChSingNum(checkSingNum(1001.00), 1001.00);
        prChSingNum(checkSingNum(-10.45), -10.45);
        System.out.println("=======================Задание 7 =================================");
        prHello("");
        prHello("Иван");
        prHello("Mike");
        System.out.println("=======================Задание 8 =================================");
        checkYear(10);
        checkYear(20);
        checkYear(100);
        checkYear(200);
        checkYear(400);
        checkYear(600);
        checkYear(1900);
        checkYear(2000);
        checkYear(2004);
        checkYear(2001);
    }

}
