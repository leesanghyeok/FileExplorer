package school.project.Listener;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FileOpenListener extends MouseAdapter{
    JTable table;
    JTree tree;
    public FileOpenListener(JTable table, JTree tree) {
        this.table = table;
        this.tree = tree;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = table.columnAtPoint(e.getPoint());
        int row = table.rowAtPoint(e.getPoint());
        if (col<0 && row<0) return;
        table.getModel().getValueAt(row,col);
        
        System.out.println(table.getModel().getValueAt(row,col));
    }
}
