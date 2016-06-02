package school.project.UI;

import school.project.Model.TabComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by forhack on 2016-05-23.
 */
public class Tab extends JTabbedPane {
    ArrayList<TabComponent> scrollPanesList = new ArrayList<TabComponent>();

    public Tab() {
        addTab("first");
        addTab("second");
    }

    public void addTab(String title) {
        int len = scrollPanesList.size();
        for (int i=0;i<len;i++) {
            if (scrollPanesList.get(i).getTitle().equals(title)) {
                setSelectedIndex(i);
                return ;
            }
        }
        
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        TabComponent tabComponent = new TabComponent(title,scrollPane);

        scrollPanesList.add(tabComponent);
        add(tabComponent.getTitle(),tabComponent.getScrollPane());
    }



}
