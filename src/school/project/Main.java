package school.project;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    JFrame mainFrame;
    JSplitPane splitPane;
    JSplitPane splitPane2;
    JLabel label1,label2, label3;
    public Main() throws HeadlessException {
        mainFrame = new StartWindow();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        label1.setText("hello");
        label2.setText("world");
        label3.setText("hahaha");

        mainFrame.add(splitPane,"Center");

        //JSplitPane 설정
        splitPane.setContinuousLayout(true); //연속적인 레이아웃 기능 활성화
        splitPane.setLeftComponent(label1); //좌측 컴포넌트 장착
        //splitPane.setRightComponent(label2); //좌측 컴포넌트 장착
        splitPane.setRightComponent(splitPane2); //우측 컴포넌트 장착
        splitPane.setDividerLocation((int)mainFrame.getSize().getWidth()/2); //디바이더(분리대) 위치 설정
        splitPane.setDividerSize(5); //디바이더(분리대) 굵기 설정

        //JSplitPane 설정
        splitPane2.setContinuousLayout(true); //연속적인 레이아웃 기능 활성화
        splitPane2.setTopComponent(label2);
        splitPane2.setBottomComponent(label3); //우측 컴포넌트 장착
        splitPane2.setDividerLocation((int)mainFrame.getSize().getWidth()/2); //디바이더(분리대) 위치 설정
        splitPane2.setDividerSize(5); //디바이더(분리대) 굵기 설정

    }

    public static void main(String args[]){
        new Main();

    }


}
