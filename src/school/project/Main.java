package school.project;

import school.project.UI.*;
import school.project.UI.Frame;
import school.project.UI.Menu;

import javax.swing.*;

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

    }

    public static void main(String args[]){
        new Main();
    }
}
