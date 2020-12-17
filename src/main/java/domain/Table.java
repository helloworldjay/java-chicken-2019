package domain;


public class Table {

    private final int number;
    private boolean isPaid = true;
    private MenuRepository tableOrderList = new MenuRepository();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void isNotPaid() {
        this.isPaid = false;
    }

    public boolean checkPayment() {
        return this.isPaid;
    }

    public void addOrder(int menuNumber, int orderAmount) {
        Menu menu = tableOrderList.getMenuByNumber(menuNumber);
        menu.orderByNumber(orderAmount);
    }

    public void clearTable() {
        tableOrderList = new MenuRepository();
        isPaid = true;
    }

    public MenuRepository getTableOrderList() {
        return tableOrderList;
    }


}
