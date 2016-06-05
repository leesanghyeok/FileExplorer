package school.project;

import school.project.Listener.FileDataSortListener;
import school.project.Listener.FileOpenListener;
import school.project.Listener.FileSaveListener;
import school.project.Listener.FindListener;
import school.project.UI.*;
import school.project.UI.Dialog.FindDialog;
import school.project.UI.Frame;
import school.project.UI.Menu;
import school.project.Util.FileUtils;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main extends JFrame {
    Frame mainFrame;
    Table table;
    Tree tree;
    Tab tab;
    Menu menu;

    JFileChooser fileChooser;

    FileOpenListener fileOpenListener;
    FileSaveListener fileSaveListener;

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
        menu = new Menu(linkFileOpenActionListenr);
        fileChooser = new JFileChooser();
        fileOpenListener = new FileOpenListener(table.getTable(),tree.getTree(),tab,menu);
        fileSaveListener = new FileSaveListener();
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
        tree.getTree().setSelectionRow(0);
    }

    private void listenerComponent() {
        tree.getTree().addTreeSelectionListener(setFilesToTableListener);
        table.getTable().addMouseListener(fileOpenListener);
        table.addTableHeaderMouseListener(new FileDataSortListener(table));
        menu.setFileOpenListener(fileOpenActionListener);
        menu.setFileSaveListener(fileSaveActionListener);
        menu.setFindListener(new FindListener(table,tree));
    }

    private TreeSelectionListener setFilesToTableListener = new TreeSelectionListener() {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            TreePath treePath = e.getPath();
            //node 이외의 장소 클릭하면 null
            if (treePath == null) return;
            //table에 files 보여주기.
            String filePath = FileUtils.treePathToString(treePath);
            File[] files = new File(filePath).listFiles();
            table.showFilesTable(files);
        }
    };

    private ActionListener fileOpenActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (fileChooser.showOpenDialog(Main.this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                fileOpenListener.fileOpen(file);
            }
        }
    };

    private ActionListener fileSaveActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filePath = tab.getTitleAt(tab.getSelectedIndex());
            File file = new File(filePath);
            JScrollPane selectedComponent = (JScrollPane)tab.getSelectedComponent();
            JTextArea ja = (JTextArea)selectedComponent.getViewport().getView();
            fileSaveListener.fileSave(file,ja.getText());
        }
    };

    private ActionListener linkFileOpenActionListenr = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem item = (JMenuItem)e.getSource();
            File file = new File(item.getText());
            fileOpenListener.fileOpen(file);
        }
    };


    public static void main(String args[]){
        new Main();
    }
}
