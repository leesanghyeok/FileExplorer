package school.project.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by forhack on 2016-05-23.
 */
public class Frame extends JFrame {
    JSplitPane horizonPane;
    JSplitPane verticalPane;
    public Frame() {
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Explorer");

        horizonPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        verticalPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        //JSplitPane 설정
        horizonPane.setContinuousLayout(true); //연속적인 레이아웃 기능 활성화
        horizonPane.setRightComponent(verticalPane); //우측 컴포넌트 장착
        horizonPane.setDividerSize(5); //디바이더(분리대) 굵기 설정

        //JSplitPane 설정
        verticalPane.setContinuousLayout(true); //연속적인 레이아웃 기능 활성화
        verticalPane.setDividerSize(5); //디바이더(분리대) 굵기 설정

        add(horizonPane);

        setVisible(true);
    }

    @Override
    public void setJMenuBar(JMenuBar menubar) {
        super.setJMenuBar(menubar);
        validate();
    }

    public void setLeftComponent(Component component){
        horizonPane.setLeftComponent(component);
        horizonPane.setDividerLocation((int)this.getSize().getWidth()/4); //디바이더(분리대) 위치 설정
    }

    public void setTopComponent(Component component){
        verticalPane.setTopComponent(component);
        verticalPane.setDividerLocation((int)this.getSize().getWidth()/5*2); //디바이더(분리대) 위치 설정

    }

    public void setBottomComponent(Component component){
        verticalPane.setBottomComponent(component);
        verticalPane.setDividerLocation((int)this.getSize().getWidth()/5*2); //디바이더(분리대) 위치 설정
    }
}
