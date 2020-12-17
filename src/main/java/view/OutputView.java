package view;

import Controller.Discount;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;

import java.util.List;

public class OutputView {

    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String UNPAID_BOTTOM_LINE = "└ \\ ┘";

    public static void printMainView() {
        System.out.println();
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println();
    }


    public static void printTables(final List<Table> tables) {
        System.out.println();
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        for (int i = 0; i < tables.size(); i++) {
            if ( !tables.get(i).checkPayment() ) {
                System.out.print(UNPAID_BOTTOM_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
        System.out.println();
    }



    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printPayment(Table table) {
        MenuRepository menuRepository = table.getTableOrderList();
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (Menu menu : menuRepository.menus()) {
            if (menu.getOrderNumber() != 0 ) {
                System.out.println(menu.getPriceMessage());
            }
        }
        System.out.println();
        System.out.println("## " + table.toString() + "번 테이블의 결제를 진행합니다.");
    }

    public static void printTotalPrice(Table table, int payment) {
        System.out.println();
        MenuRepository menuRepository = table.getTableOrderList();
        int totalPrice = 0;
        int chickenNumber = 0;
        for (Menu menu : menuRepository.menus()) {
            if ( menu.isChicken() ) {
                chickenNumber += 1;
            }
            totalPrice += menu.getPrice();
        }
        int disCount = Discount.makeChickenDiscount(chickenNumber);
        totalPrice -= disCount;
        if (payment == 2) {
            totalPrice = Discount.cashDiscount(totalPrice);
        }
        System.out.println("## 최종 결제할 금액");
        System.out.println( totalPrice + "원"); // string + int는 자동 string 형번환
    }
}
