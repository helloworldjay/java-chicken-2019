package Controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class OrderMenu {
    public static void orderFoods(List<Table> tables){
        OutputView.printTables(tables); // 전체 테이블 그려주기
        final int tableNumber = InputView.inputTableNumber();
        Table table = TableRepository.getTable(tableNumber);
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        int selectedMenu = InputView.inputMenu();
        int selectedMenuAmount = InputView.inputMenuAmount();
        table.isNotPaid();
        table.addOrder(selectedMenu, selectedMenuAmount);
        MainSelection.selectMain(tables);
    }
}
