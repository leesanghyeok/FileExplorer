package school.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Main extends JFrame {
    JFrame mainFrame;
    JSplitPane splitPane;
    JSplitPane splitPane2;
    JLabel label1,label2, label3;
    DefaultMutableTreeNode root;
    JTree tree;
    JTable table;

    public Main() throws HeadlessException {
        mainFrame = new StartWindow();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        mainFrame.add(splitPane);

        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        label1.setText("hello");
        label2.setText("world");
        label3.setText("hahaha");


        String []cols = {"이름","주소","집","전번","asd"};
        String [][]rows = {{"1","2","3","4"},{"1","1","1","1"}};
        DefaultTableModel model = new DefaultTableModel(rows,cols);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);


        root = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode rrr = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode r11r = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode rr = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode rrr1 = new DefaultMutableTreeNode("root");
        root.add(rrr);
        root.add(r11r);
        rrr.add(rr);
        rr.add(rrr1);
        tree = new JTree(root);

        JTabbedPane tabbed = new JTabbedPane();
        JPanel first = new JPanel();
        JPanel second = new JPanel();
        tabbed.add("first",first);
        tabbed.add("second",second);


        //JSplitPane 설정
        splitPane.setContinuousLayout(true); //연속적인 레이아웃 기능 활성화
        splitPane.setLeftComponent(tree); //좌측 컴포넌트 장착
        //splitPane.setRightComponent(label2); //좌측 컴포넌트 장착
        splitPane.setRightComponent(splitPane2); //우측 컴포넌트 장착
        splitPane.setDividerLocation((int)mainFrame.getSize().getWidth()/2); //디바이더(분리대) 위치 설정
        splitPane.setDividerSize(5); //디바이더(분리대) 굵기 설정


        //JSplitPane 설정
        splitPane2.setContinuousLayout(true); //연속적인 레이아웃 기능 활성화
        splitPane2.setTopComponent(scrollPane);
        splitPane2.setBottomComponent(tabbed); //우측 컴포넌트 장착
        splitPane2.setDividerLocation((int)mainFrame.getSize().getWidth()/2); //디바이더(분리대) 위치 설정
        splitPane2.setDividerSize(5); //디바이더(분리대) 굵기 설정



    }

    public static void main(String args[]){
        new Main();

    }


}
