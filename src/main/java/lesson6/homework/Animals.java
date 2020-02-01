package lesson6.homework;

public abstract class Animals {
    String type;
    double MaxLen;

    public Animals(String type) {
        this.type = type;
    }

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_WHITE = "\u001B[37m";

    String[] Color = new String[]{ ANSI_CYAN, ANSI_BLUE, ANSI_PURPLE,
              ANSI_YELLOW,  ANSI_GREEN,  ANSI_RED
    };

    void printColorLine(int cnt, boolean res){
        for (int i = 0; i < cnt; i++) {
            System.out.printf(Color[i]+"===");
        }
        System.out.printf( " ->"+res+ANSI_RESET+" ");
    }


    //бежать
    public boolean run(double len ){
        if (len <= MaxLen) {
            if (len <= MaxLen/2){
                printColorLine(3, true);
            }else{
                printColorLine(5, true);
            }
            return true;
        } else {
            printColorLine(6, false);
            return false;
        }
    }

    //плыть
    public boolean swim(double len) {
        if (len <= MaxLen) {
            if (len <= MaxLen / 2) {
                printColorLine(3, true);
            } else {
                printColorLine(5, true);
            }
            return true;
        } else {
            printColorLine(6, false);
            return false;
        }
    }
    //перепрыгивать

    public boolean jump(double len){
        if (len <= MaxLen) {
            if (len <= MaxLen/2){
                printColorLine(3, true);
            }else{
                printColorLine(5, true);
            }
            return true;
        } else {
            printColorLine(6, false);
            return false;
        }
    }

    public void getType() {
        System.out.println(type);
    }
}
