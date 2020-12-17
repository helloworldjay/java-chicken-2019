package Controller;

import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class PaymentMenu {

    public static void getPayment(List<Table> tables) {
        OutputView.printTables(tables); // 전체 테이블 그려주기
        final int tableNumber = InputView.inputTableNumber();
        Table table = TableRepository.getTable(tableNumber);
        OutputView.printPayment(table);
        int payment = InputView.payCardOrCash();
        OutputView.printTotalPrice(table);
        table.clearTable();
        MainSelection.selectMain(tables);
    }
}
