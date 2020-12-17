package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {

    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table getTable(int number) {
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).toString().equals(Integer.toString(number))) {
                return tables.get(i);
            }
        }
        return new Table(-1); // 처리 방법이 애매
    }
}
