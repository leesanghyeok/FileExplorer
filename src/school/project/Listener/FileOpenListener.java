package school.project.Listener;

import school.project.UI.Table;
import school.project.Util.FileUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

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

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        String fileParentPath = FileUtils.treeNodesToString(node.getPath());
        String fileName = table.getModel().getValueAt(row, Table.COLUMN_NAME).toString();
        String fileAbsolutePath = fileParentPath + File.separator + fileName;

        System.out.println(fileAbsolutePath);
    }
}
