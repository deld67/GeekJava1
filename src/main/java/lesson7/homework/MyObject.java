package lesson7.homework;
interface getFoot{
    int getFood();
        };
interface setFoot{
    void setFood(int foot);
        }
public abstract class MyObject  implements setFoot, getFoot{
    int foot = 0;
    String type = "";
    String name = "";

    public MyObject(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getFood() {
        return foot;
    }

    public void setFood(int foot) {
        this.foot = foot < 0? 0: foot;
    }
}
