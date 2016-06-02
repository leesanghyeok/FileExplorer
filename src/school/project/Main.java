package school.project;

import school.project.Listener.FileOpenListener;
import school.project.UI.*;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

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

        //트리의 첫번가장 root 노드의 file들을 보여줘라.
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getTree().getModel().getRoot();
        File[] files = new File(node.getUserObject().toString()).listFiles();
        table.showFilesTable(files);
    }

    private void listenerComponent() {
        tree.getTree().addTreeSelectionListener(setFilesToTableListener);
        table.getTable().addMouseListener(new FileOpenListener(table.getTable(),tree.getTree()));
    }

    private TreeSelectionListener setFilesToTableListener = new TreeSelectionListener() {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            TreePath treePath = e.getPath();
            //node 이외의 장소 클릭하면 null
            if (treePath == null) return;
            //table에 files 보여주기.
            String filePath = tree.treePathToString(treePath);
            File[] files = new File(filePath).listFiles();
            table.showFilesTable(files);
        }
    };

    public static void main(String args[]){
        new Main();
    }
}
