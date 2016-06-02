package school.project.Model;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * Created by forhack on 2016-06-02.
 */
public class TableModel extends AbstractTableModel {
    public TableModel() {
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
