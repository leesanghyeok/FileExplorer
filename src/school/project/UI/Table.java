package school.project.UI;

import school.project.Model.FileData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;

/**
 * Created by forhack on 2016-05-23.
 */
public class Table extends JScrollPane {
    public static int COLUMN_NAME = 0;
    public static int COLUMN_LAST_MODIFIED = 1;
    public static int COLUMN_TYPE = 2;
    public static int COLUMN_SIZE = 3;

    JTable table;
    DefaultTableModel model;
    public Table() {
        table = new JTable();
        String []cols = {"이름","수정한 날짜","유형","크기"};
        String [][]rows = {{"이름","수정한 날짜","유형","크기"}};

        model = new DefaultTableModel(rows,cols);

        //Model.addcolumn

        table.setModel(model);
        setViewportView(table);
    }

    public void showFilesTable(File[] files) {
        //기존 테이블 삭제
        Clear();
        int len = files.length;
        for (int i=0;i<len;i++) {
            FileData fileData = new FileData(files[i].isDirectory(),files[i].getAbsolutePath(),files[i].lastModified(),files[i].length());
            model.addRow(fileData.toStrings());
        }

    }

    public void Clear() {
        int rows = model.getRowCount();
        for(int i = rows - 1; i >=0; i--) {
            model.removeRow(i);
        }
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
