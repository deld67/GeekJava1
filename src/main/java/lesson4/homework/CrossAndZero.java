package lesson4.homework;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class CrossAndZero {

    public static int[][] map;
    public static  int SIZE = 4;
    public static  int DOTS_TO_WIN = 4;
    public static int COUNT_STEP = SIZE * SIZE;

    public  static char[] DOTS;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void initMap() {
        DOTS = new char[]{'•','X','O'};
        map = new int[SIZE+2][SIZE+2];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = 0;
            }
            map[i][SIZE] = 0;
            map[i][SIZE+1] = 0;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < SIZE+2; j++) {
                map[SIZE + i][j] = 0;
            }
        }
    }
    public static void printMap(int [][] array) {
        System.out.println(" Y");
        System.out.printf("X ");
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
//        System.out.printf("||" + DOTS[1] + "|" + DOTS[2]);
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print("  "+(i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(DOTS[array[i][j]] + " ");
            }
//            System.out.printf("||" + Integer.toBinaryString(array[i][SIZE]) + "|" + Integer.toBinaryString(array[i][SIZE + 1]));
            System.out.println();
        }
//        System.out.println("===============");

//        for (int j = 0; j < 2; j++) {
//            System.out.printf("  "+DOTS[j+1]+" ");
//            for (int i = 0; i < SIZE; i++) {
//                System.out.printf(Integer.toBinaryString(array[SIZE+j][i]) + " ");
//            }
//            System.out.printf("||" + Integer.toBinaryString(array[SIZE+j][SIZE]) + "|" + Integer.toBinaryString(array[SIZE+j][SIZE + 1]));
//            System.out.println();
//        }

    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == 0 ) return true;
        return false;
    }
    public static void calcGame(int y, int x, int [][] array) {
        array[y][SIZE] = 0;
        array[y][SIZE+1] = 0;
        array[SIZE][x] = 0;
        array[SIZE+1][x] = 0;
        //map[y][x] = 1;
        for (int i = 0, k = 1; i < SIZE; k <<= 1, i++) {
            switch (DOTS[array[y][i]]){
                case DOT_X:
                    array[y][SIZE] += k;
                    break;
                case DOT_O:
                    array[y][SIZE + 1] += k;
                    break;
            }
            switch (DOTS[array[i][x]]){
                case DOT_X:
                    array[SIZE][x] += k;
                    break;
                case DOT_O:
                    array[SIZE+1][x] += k;
                    break;
            }
        }
        if (x == y) {
            array[SIZE][SIZE] = 0;
            array[SIZE+1][SIZE]=0;
            for (int i = 0, k = 1; i < SIZE ; k<<=1,i++) {
                switch (DOTS[array[i][i]]){
                    case DOT_X:
                        array[SIZE][SIZE] += k;
                        break;
                    case DOT_O:
                        array[SIZE+1][SIZE] += k;
                        break;
                }
            }
        }
        if (SIZE - y - 1 - x == 0) {
            array[SIZE][SIZE + 1] = 0;
            array[SIZE + 1][SIZE + 1] = 0;
            for (int i = 0, k = 1; i < SIZE; k<<=1, i++) {
                switch (DOTS[array[SIZE - i - 1][i]]){
                    case DOT_X:
                        array[SIZE][SIZE+1] += k;
                        break;
                    case DOT_O:
                        array[SIZE+1][SIZE+1] += k;
                        break;
                }
            }
        }

    }
    public static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = 1;
        calcGame(y, x, map);
    }
    private static void ch_conor(int x1, int y1,  int x, int y){
        switch (DOTS[map[x1][y1]]){
            case DOT_X:
                if (DOTS[map[SIZE-1 - x1][SIZE-1 - y1]] == DOT_EMPTY){
                    x = SIZE-1 - x1;
                    y = SIZE-1 - y1;
                }
                break;
            case DOT_EMPTY:
                x = x1;
                y = y1;
                break;
        }
    }
    public static void aiTurn() {
        int [][] c_map;
        int x = -1, y = -1, xp = -1, yp = -1 ;
        if (COUNT_STEP == SIZE * SIZE ){
             x = SIZE / 2;
             y = SIZE / 2;
        }
        if (x < 0 && y < 0) ch_conor(0,0, x, y);
        if (x < 0 && y < 0) ch_conor(SIZE-1,SIZE-1, x, y);
        if (x < 0 && y < 0) ch_conor(0,SIZE-1, x, y);
        if (x < 0 && y < 0) ch_conor(SIZE-1,0, x, y);

        if (x < 0 && y < 0 ){
            c_map = Arrays.copyOf(map, map.length);
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (DOTS[c_map[i][j]] == DOT_EMPTY){
                        c_map[i][j] = 1;
                        calcGame(i, j, c_map);
                        //printMap(c_map);
                        if (checkWin(c_map) == DOT_X){
                            yp = i;
                            xp = j;
                            c_map[i][j] = 0;
                            calcGame(i, j, c_map);
                            break;
                        }else{
                            c_map[i][j] = 2;
                            calcGame(i, j, c_map);
                            //printMap(c_map);
                            if (checkWin(c_map) == DOT_O){
                                y = i;
                                x = j;
                                c_map[i][j] = 0;
                                calcGame(i, j, c_map);
                                break;
                            }else{
                                c_map[i][j] = 0;
                                calcGame(i, j, c_map);
                                //printMap(c_map);
                            }
                        }
                    }
                }
                if (y > -1 && x > -1) break;
            }
            if (x < 0 && xp >= 0) x = xp;
            if (y < 0 && yp >= 0) y = yp;
        }
        if (x < 0 && y < 0) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = 2;
        calcGame(y, x, map);
    }
    public static char checkWin(int [][] array){
        for (int cDOTS_TO_WIN = DOTS_TO_WIN; Integer.toBinaryString(cDOTS_TO_WIN).length() <= SIZE ; cDOTS_TO_WIN <<=1) {
            for (int i = SIZE; i < array.length; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if ((array[i][j] & cDOTS_TO_WIN) == cDOTS_TO_WIN){
                        if (i == SIZE) {
                            return DOT_X;
                        }else {
                            return DOT_O;
                        }
                    }
                    if ((array[j][i] & cDOTS_TO_WIN) == cDOTS_TO_WIN){
                        if (i == SIZE) {
                            return DOT_X;
                        }else {
                            return DOT_O;
                        }
                    }
                }
                if ((array[SIZE][i] & cDOTS_TO_WIN) == cDOTS_TO_WIN ){
                    return DOT_X;
                }
                if ((array[SIZE+ 1][i] & cDOTS_TO_WIN) == cDOTS_TO_WIN ){
                    return DOT_O;
                }
            }
        }
        return DOT_EMPTY;
    }
    public static void GameCase(){
        int caseGame = 0;
        do {
            System.out.println("1 - поле 3х3, кол-во фишек 3 ");
            System.out.println("2 - поле 4х4, кол-во фишек 4 ");
            System.out.println("3 - поле 5х5, кол-во фишек 4 ");
            System.out.println("4 - поле 5х5, кол-во фишек 5 ");
            System.out.println("Вы берите поле и сложность игры:");
            caseGame = sc.nextInt();
        } while (caseGame < 0 && caseGame > 4);
        switch (caseGame){
            case 1:
                SIZE = 3;
                DOTS_TO_WIN = 0b111;
                break;
            case 2:
                DOTS_TO_WIN = 0b1111;
                SIZE = 4;
                break;
            case 3:
                DOTS_TO_WIN = 0b1111;
                SIZE = 5;
                break;
            case 4:
                SIZE = 5;
                DOTS_TO_WIN = 0b11111;
                break;
        }
    }
    public static boolean nextGame(){
        int n = 0;
        do {
            System.out.println("Сыграем ещё? (1 - Да, 2 - Нет)");
            n = sc.nextInt();
        } while (n < 0 && n > 2);

        if (n == 1 ) return true;
        return false;
    }

    public static void main(String[] args) {

        char stepResult = DOT_EMPTY;
        do {
            GameCase();
            COUNT_STEP = SIZE * SIZE;

            initMap();
            printMap(map);
            while (COUNT_STEP > 0) {
                if (COUNT_STEP % 2 == 0) {
                    aiTurn();
                } else {
                    humanTurn();
                }
                printMap(map);
                stepResult = checkWin(map);
                if (stepResult == DOT_X) {
                    System.out.println("Вы победили!");
                    break;
                } else if (stepResult == DOT_O) {
                    System.out.println("Вы проиграли!");
                    break;
                }
                COUNT_STEP--;
            }
            if (COUNT_STEP == 0) System.out.println("Все ходы закончились. НИЧЬЯ!");
        }while (nextGame());

    }
}

