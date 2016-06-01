package school.project;

import school.project.UI.*;
import school.project.UI.Frame;
import school.project.UI.Menu;
import school.project.model.FileData;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends JFrame {
    Frame mainFrame;
    Table table;
    Tree tree;
    Tab tab;
    Menu menu;

    public Main() {
        initComponent();
        settingComponent();
        listenerComponent();
    }

    private void initComponent() {
        mainFrame = new Frame();
        tree = new Tree();
        table = new Table();
        tab = new Tab();
        menu = new Menu();
    }

    private void settingComponent() {
        mainFrame.setJMenuBar(menu);
        mainFrame.setLeftComponent(tree);
        mainFrame.setTopComponent(table);
        mainFrame.setBottomComponent(tab);
    }

    private void listenerComponent() {
        tree.addMouseListener(setFileListListener);
    }

    private MouseAdapter setFileListListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            //더블클릭시 이상하게 클릭되는것 방지 하기위해 클릭 횟수 한번으로 고정
            if (e.getClickCount()!=1) return ;
            TreePath treePath = tree.getPathForLocation(e.getX(), e.getY());
            //node 이외의 장소 클릭하면 null
            if (treePath == null) return;

            String filePath = tree.treePathToString(treePath);
            File file = new File(filePath);
            FileData fileData = new FileData(file.isDirectory(),file.getName(),file.lastModified(),file.length());

            System.out.println(fileData.getName());
            System.out.println(fileData.getLastModified());
            System.out.println(fileData.getSize());
            System.out.println(fileData.getExt());
        }
    };

    public static void main(String args[]){
        new Main();
    }
}
