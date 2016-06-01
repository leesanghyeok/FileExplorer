package school.project.UI;

import school.project.model.FileData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

/**
 * Created by forhack on 2016-05-23.
 */
public class Table extends JScrollPane {
    JTable table;
    DefaultTableModel model;
    public Table() {
        table = new JTable();
        String []cols = {"이름","수정한 날짜","유형","크기"};
        String [][]rows = {{"이름","수정한 날짜","유형","크기"}};

        model = new DefaultTableModel(rows,cols);
        //model.addcolumn

        table.setModel(model);
        setViewportView(table);
    }

    public void showFilesTable(File[] files) {
        //기존 테이블 삭제
        Clear();
        int len = files.length;
        for (int i=0;i<len;i++) {
            FileData fileData = new FileData(files[i].isDirectory(),files[i].getName(),files[i].lastModified(),files[i].length());
            model.addRow(fileData.toStrings());
        }
    }

    public void Clear() {
        int rows = model.getRowCount();
        for(int i = rows - 1; i >=0; i--) {
            model.removeRow(i);
        }
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
