package school.project.Listener;

import school.project.UI.FilePanel.FileIcon;
import school.project.UI.FilePanel.IconTable;
import school.project.UI.Menu;
import school.project.UI.Tab;
import school.project.UI.FilePanel.Table;
import school.project.Util.FileUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.ObjectInput;

public class FileOpenListener extends MouseAdapter{
    JTable table;
    JTree tree;
    Tab tab;
    Menu menu;
    IconTable iconTable;
    public FileOpenListener(JTable table, JTree tree, Tab tab, Menu menu, IconTable iconTable) {
        this.table = table;
        this.tree = tree;
        this.tab = tab;
        this.menu = menu;
        this.iconTable = iconTable;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount()!=2) return;

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        String fileName = getFileName(e);
        if (fileName.equals("")) return;
        System.out.println(fileName);
        //검색했을 때는, 이름 부분이 absolutePath가 된다. 그래서 파일이 만들어지는지 체크하고 못만들면 평소대로 하자.
        File file = new File(fileName);
        if (!file.exists()) {
            String fileParentPath = FileUtils.treeNodesToString(node.getPath());
            String fileAbsolutePath = fileParentPath + File.separator + fileName;
            file = new File(fileAbsolutePath);
        }
        fileOpen(file);
    }

    private String getFileName(MouseEvent e) {
        String fileName = "";
        System.out.println(e.getX() +" "+ e.getY());
        if (e.getSource() instanceof JTable) {
            int col = table.columnAtPoint(e.getPoint());
            int row = table.rowAtPoint(e.getPoint());
            if (col < 0 && row < 0) return "";
            fileName = table.getModel().getValueAt(row, Table.COLUMN_NAME).toString();
        } else if (e.getSource() instanceof FileIcon) {
            FileIcon label = (FileIcon)e.getSource();
            fileName = label.getText();
        } else {
            System.out.println("asddddddf");
        }
        return fileName;
    }

    public void fileOpen(File file){
        String fileData = FileUtils.getFileData(file);
        if (file.isDirectory()) {
            JOptionPane.showMessageDialog(null, "텍스트 문서가 아닙니다.", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            menu.addLinkMenu(file.getAbsolutePath());
            tab.addTab(file.getAbsolutePath(), fileData);
        }
    }
}
