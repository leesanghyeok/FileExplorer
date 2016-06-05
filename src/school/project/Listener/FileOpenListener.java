package school.project.Listener;

import school.project.UI.Tab;
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
    Tab tab;
    public FileOpenListener(JTable table, JTree tree, Tab tab) {
        this.table = table;
        this.tree = tree;
        this.tab = tab;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount()!=2) return;
        int col = table.columnAtPoint(e.getPoint());
        int row = table.rowAtPoint(e.getPoint());
        if (col<0 && row<0) return;

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        String fileParentPath = FileUtils.treeNodesToString(node.getPath());
        String fileName = table.getModel().getValueAt(row, Table.COLUMN_NAME).toString();
        String fileAbsolutePath = fileParentPath + File.separator + fileName;
        File file = new File(fileAbsolutePath);
        fileOpen(file);
    }

    public void fileOpen(File file){
        String fileData = FileUtils.getFileData(file.getAbsolutePath());
        if (file.isDirectory()) {
            JOptionPane.showMessageDialog(null, "텍스트 문서가 아닙니다.", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            tab.addTab(file.getName(), fileData);
        }
    }
}
