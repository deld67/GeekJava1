package lesson3.homework;

import java.util.Arrays;
import java.util.Random;

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
        return 0;
    }
    /* example:
     * input: [1,0,3,17,2,7,14,1,1,7], K = 6
     * output: 3
     * use sort
     * */
    public int kOrderValue(int [] array, int k) {
        //метод должен вернуть К по порядку элемент массива
        return 0;
    }
    /* example:
     * input: m.levin.main@mailg.spb.com
     * output: true
     *
     * use matches
     * */
    public boolean isEmail(String input) {
        // TODO: 1/21/2020
        return false;
    }

    public void binarySearchGame() {
        int secretValue = new Random().nextInt(100); // компьютер загадывает число
        // TODO: 20.01.2020
        //мы печатаем в консоль наши предположения (в цикле), компютер отвечает > , < или =
        //на каждый наш вопрос
        //если задано более 7 вопросов и не угадано значение, мы проиграли
        //если компютер вывел =, мы выиграли
    }

    public void wordsGame() {
        // TODO: 20.01.2020  
    }
}
