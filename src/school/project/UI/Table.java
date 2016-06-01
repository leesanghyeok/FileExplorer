package school.project.UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by forhack on 2016-05-23.
 */
public class Table extends JScrollPane {
    JTable table;
    public Table() {
        table = new JTable();
        String []cols = {"이름","수정한 날짜","유형","크기"};
        String [][]rows = {{"1","2","3","4"},{"1","1","1","1"}};
        DefaultTableModel model = new DefaultTableModel(rows,cols);


        table.setModel(model);
        setViewportView(table);

    }
}
