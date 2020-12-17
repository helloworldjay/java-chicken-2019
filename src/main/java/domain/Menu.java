package domain;

public class Menu {

    private final int number;
    private final String name;
    private final Category category;
    private final int price;
    private int orderNumber = 0;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public boolean isChicken() {
        if (category.toString().equals("[치킨]")) {
            return true;
        }
        return false;
    }

    public String getPriceMessage() {
        return name + " " + Integer.toString(orderNumber) + " "+ Integer.toString(orderNumber * price);
    }

    public int getPrice() {
        return orderNumber * price;
    }

    public int getNumber() {
        return this.number;
    }

    public void orderByNumber(int orderNumber) {
        this.orderNumber += orderNumber;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }
}
