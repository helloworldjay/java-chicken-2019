import Controller.MainSelection;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        MainSelection.selectMain(tables);
    }
}
