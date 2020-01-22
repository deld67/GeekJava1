package lesson2.homework;

import java.util.Arrays;
import java.util.Random;

public class HomeWork {
    // TODO: 17.01.2020 Tarasov Sergey

    // Задать целочисленный массив, состоящий из элементов 0 и 1.
    //        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    //        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    static void task1(){
        int[] a = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Array before chenge:");
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length  ; a[i] = a[i] ^ 1, i++) {}
        System.out.println("Array after chenge:");
        System.out.println(Arrays.toString(a));
    }
    //Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    static void task2(){
        int[] a = new int[8];
        for (int i = 0; i < 8; a[i] = i * 3, i++) {}
        System.out.println("Array after chenge:");
        System.out.println(Arrays.toString(a));
    }
    //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    static void task3(){
        int[] a = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Array before chenge:");
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length ; i++) {
            if (a[i] < 6) {a[i] *= 2;}
        }
        System.out.println("Array after chenge:");
        System.out.println(Arrays.toString(a));
    }
    //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    static void task4(int row){
        int[][] a = new int[row][row];
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < row; j++) {
                a[i][j] = 0;
            }
            a[i][i] = 1;
            a[i][row -1 -i] = 1;
        }
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < row; j++) {
                System.out.printf("%3d", a[j][i]);
            }
            System.out.println();
        }
    }
    //Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    static void task5(int cnt){
        int[] a = new int[cnt];
        int   iMax= 0, iMin = 0, el;
        for (int i = 0; i < cnt ; i++) {
            a[i] = new Random().nextInt(cnt);
            while (a[i]  < 0) a[i]  = new Random().nextInt(cnt);
        };
        System.out.println("Created array:");
        System.out.println(Arrays.toString(a));
        for (int i = 1, j = cnt-1; i <= cnt/2  ;  i++, j= cnt -i) {
            if (a[i] > a[iMax] | (a[i] == a[iMax] && i < iMax )) iMax = i;
            if (a[j] > a[iMax] | (a[j] == a[iMax] && j < iMax ))  iMax = j;
            if (a[i] < a[iMin] | (a[i] == a[iMin] && i < iMin )) iMin = i;
            if (a[j] < a[iMin] | (a[j] == a[iMin] && j < iMin )) iMin = j;
        }
        System.out.println("Maximum element:"+a[iMax]+" at index "+(iMax+1));
        System.out.println("Minimum element:"+a[iMin]+" at index "+(iMin+1));
    }
    //Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    static boolean task6(int[] arr){
        int sumArr1 = 0, sumArr2 = 0;
        for (int i = 0; i < arr.length-1; i++) {
            sumArr1 += arr[i];
            sumArr2 = 0;
            for (int j = i+1; j < arr.length ; j++) {
                sumArr2 += arr[j];
            }
            if (sumArr1 == sumArr2)  return true;
        }
        return false;
    }
    //Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементымассива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    static void task7(String[] arr, int n){
        System.out.println(Arrays.toString(arr));
        if (n == 0){
            System.out.println("Колличество позиций сдвига равно нулю, сдвиг не производится.");
            return;
        }

        for (int i = 1; i <= Math.abs(n); i++) {
            if (i > arr.length) break;
            for (int j = 0; j < arr.length; j++) {
                if (n > 0) {
                    //if (arr[arr.length - 1 - j] == "") break;
                    if (j < (arr.length - 1)) arr[arr.length - 1 - j] = arr[arr.length - 2 - j];
                    if (j == (arr.length - 1)) arr[0] = "";
                }else{
                    //if (arr[j] == "") break;
                    if (j < (arr.length - 1)) arr[j] = arr[j+1];
                    if (j == (arr.length - 1)) arr[j] = "";
                }
            }
        }
        System.out.println("Резултат сдвига на  "+n+" позиций:");
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {

        System.out.println("================== task 1 ==========================");
        task1();
        System.out.println("====================================================");
        System.out.println("================== task 2 ==========================");
        task2();
        System.out.println("====================================================");
        System.out.println("================== task 3 ==========================");
        task3();
        System.out.println("====================================================");
        System.out.println("================== task 4 ==========================");
        task4(10);
        System.out.println("====================================================");
        System.out.println("================== task 5 ==========================");
        int s = new Random().nextInt(20);
        s = s > 0 ? s: 10 ;
        task5(s);
        System.out.println("====================================================");
        System.out.println("================== task 6 ==========================");
        s = new Random().nextInt(20);
        s = s > 0? s: 10;
        int[] a = new int[s];
        for (int i = 0; i < s; i++){
            a[i] = new Random().nextInt(5);
            while ( a[i] < 0) a[i] = new Random().nextInt(5);
        }
        System.out.println("Created array:");
        System.out.println(Arrays.toString(a));
        System.out.println("Граница в массиве"+(task6(a) == true? " ":" не ")+"найдена");
        System.out.println("====================================================");
        System.out.println("================== task 7 ==========================");
        s = new Random().nextInt(20);
        s = s > 0? s: 10;
        String[] arrC = new String[s];
        for (int i = 0; i < s; arrC[i] = ""+new Random().nextInt(5)+"", i++){}
        task7(arrC, 5);
        System.out.println("====================================================");
    }
}
