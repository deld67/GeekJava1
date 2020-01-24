package lesson3.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {

    /* example:
     * input: Mama mila ramu, Ramu mila mama!!!, [mama, ramu]
     * output: 4
     * use regex, split, lowerCase, replace methods
     * */
    public int countOfWordsFromDictionaryInString(String input, String [] dictionary) {
        //посчитать все слова из словаря в input
        //если одно слово встречается 5 раз его нужно посчитать 5 раз
        // TODO: 1/21/2020
        int count_wrd = 0;
        String [] words = input.trim().toLowerCase().split("\\W+| +");
        System.out.println(Arrays.toString(words));
        for (String dict : dictionary) {
            for (String wrd : words)
                if (wrd.equals(dict)) {
                    count_wrd++;
                }
        }
        return count_wrd;
    }
    /*Альтернативный варинт решения задачи используется только use  lowerCase, indexOf  methods*/
    public int countOfWordsFromDictionaryInStringAlt(String input, String [] dictionary) {
        //посчитать все слова из словаря в input
        //если одно слово встречается 5 раз его нужно посчитать 5 раз
        // TODO: 1/21/2020
        int count_wrd = 0;
        for (String dict : dictionary) {
            int st_pos = 0;
            st_pos = input.trim().toLowerCase().indexOf(dict, st_pos) ;
            while (st_pos >= 0){
                count_wrd++;
                st_pos = input.trim().toLowerCase().indexOf(dict, st_pos+1) ;
            }
        }
        return count_wrd;
    }

    /*
     *  Это реальная задача, которую я сегодня делал на работе
     *  Кому интересно, можете проверить свои силы))))
     *  Если слово из values есть в словаре from, его необходимо заменить
     *  с from[i] на to[i] [a, b, c], [a, b], [x, y] -> [x, y, c]
     *  Если словарь to длиннее from, то строка to[from.length] - дефолтное
     *  значение для всех values, которых нет в словаре from
     *  [a, b, c, d], [a, b], [x, y, lol] -> [x, y, lol, lol]
     *  Если словарь from длиннее to, то необходимо удалить из values все значения
     *  имющиеся в куске from на индексах от to.length до rom.length
     *  [a, b, c, d], [a, b, e, d], [x, y] -> [x, y, c] d удалем, так как он есть во
     *  from
     */

    public  String[] translate(String[] values, String[] from, String[] to) {
        // TODO: 1/22/2020
        String[] ret_arr = new String[values.length];
        int n = 0;
        for (int i = 0; i < values.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < from.length; j++) {
                if(values[i].equals(from[j])) {
                    if (j < to.length){
                        ret_arr[n] = to[j];
                        n++;
                    }
                    isFound = true;
                    break;
                }
            }
            if (isFound == true) continue;
            if (to.length > from.length){
                ret_arr[n] = to[from.length];
                n++;
            }else{
                ret_arr[n] = values[i];
                n++;
            }
        }
        values = Arrays.copyOfRange(ret_arr, 0, n--);
        return null;
    }

    /* example:
     * input: [1,0,3,17,2,7,14,1,1,7], K = 6
     * output: 3
     * use sort
     * */
    public  int kOrderValue(int [] array, int k) {
        //метод должен вернуть К по порядку элемент массива
        if (k == 0) return -0;
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(k);
        k = k%array.length == 0? array.length-1 : k%array.length;
        System.out.println(k);
        return array[k];
    }
    /* example:
     * input: m.levin.main@mailg.spb.com
     * output: true
     *
     * use matches
     * */
    public  boolean  isEmail(String input) {
        // TODO: 1/21/2020
        return input.matches("([a-zA-Z0-9\\_\\-]+\\.?)+\\@[a-zA-Z0-9\\_\\-]+\\.([a-zA-Z0-9\\_\\-]+\\.?)+");
    }

    public  Scanner sc = new Scanner(System.in);

    public  int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            System.out.println(message);
            x = sc.nextInt();
        } while (x < min || x > max);
        return x;
    }

    public void binarySearchGame() {
        int secretValue = new Random().nextInt(100);
        int maxP = 7;
        // компьютер загадывает число
        // TODO: 20.01.2020
        //мы печатаем в консоль наши предположения (в цикле), компютер отвечает > , < или =
        //на каждый наш вопрос
        //если задано более 7 вопросов и не угадано значение, мы проиграли
        //если компютер вывел =, мы выиграли
        while (maxP > 0) {
            int d = getNumberFromScanner("Введите число в пределах от 0 до 100", 0, 100);
            if (d > secretValue) {
                System.out.println("Ваше чиисло больше загаданного. Осталось попыток:"+(maxP-1) );
            } else  if (d < secretValue){
                System.out.println("Ваше чиисло меньше загаданного. Осталось попыток:"+(maxP-1) );
            }else{
                System.out.println("Вы выиграли. Загаданное число: "+secretValue);
                break;
            }
            maxP --;
        }
        if (maxP == 0){
            System.out.println("Вы проиграли. Загаданное число:"+secretValue);
        }
    }
    public  String printMask( String str1, String str2 ){
        String mask = "";
        str1 = str1.trim().toLowerCase();
        str2 = str2.trim().toLowerCase();

        for (int i = 0; i < Math.min(str2.length(), str1.length()); i++) {
            if (str2.substring(i,i+1).equals(str1.substring(i,i+1))) {
                mask += str2.substring(i, i + 1);
            }else{
                mask += "#";
            }
        }
        for (int i = mask.length(); i < 15; i++) {
            mask +="#";
        }
        return mask;
    }
    public  void wordsGame() {
        // TODO: 20.01.2020
        String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int k = new Random().nextInt(words.length);
        //System.out.println(Arrays.toString(words));
        //System.out.println(words[k]);
        boolean stop = false;
        while (stop != true) {
            System.out.println("введите загаданное слово:");
            String word = sc.next();
            if (word.trim().toLowerCase().equals(words[k])){
                System.out.println("Угадали!!!");
                stop = true;
            }else{
                System.out.println("Не угадали. Попробуйте еще раз.");
                System.out.println("Подсказка. В Вашем слове совпадают с загаданным словом следующие буквы:\n "+printMask(word, words[k]) );
            }


        }
    }


}
