package Controller;

public class Discount {

    public static int makeChickenDiscount(int chickenNumber) {
        return (chickenNumber/10) * 10000;
    }

    public static int cashDiscount(int totalPrice) {
        return (int)(totalPrice*0.95);
    }
}
