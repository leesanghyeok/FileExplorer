package school.project;

import school.project.UI.Frame;
import school.project.UI.Tab;
import school.project.UI.Table;
import school.project.UI.Tree;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Main extends JFrame {
    Frame mainFrame;
    Table table;
    Tree tree;
    Tab tab;

    public Main() throws HeadlessException {
        mainFrame = new Frame();

        tree = new Tree();
        table = new Table();
        tab = new Tab();

        mainFrame.setLeftComponent(tree);
        mainFrame.setTopComponent(table);
        mainFrame.setBottomComponent(tab);


    }

    public static void main(String args[]){
        new Main();
    }
}
