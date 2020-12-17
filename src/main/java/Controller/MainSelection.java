package Controller;

import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class MainSelection {

    public static void selectMain(List<Table> tables) {
        OutputView.printMainView();
        int userSelection = InputView.inputSelection(); // 원하는 기능
        selectOption(userSelection, tables); // 입력받은 기능으로 실행

    }

    public static void selectOption(int userSelection, List<Table> tables) {
        if (userSelection == 1) {
            OrderMenu.orderFoods(tables);
        } // 주문하기
        if (userSelection == 2) {
            PaymentMenu.getPayment(tables);
        } // 결제하기
    }
}
