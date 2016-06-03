package school.project.UI;

import school.project.ButtonTabComponent;
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
        addTab("first", "qwqweqe");
        addTab("second", "asdfasdf");
    }

    @Override
    public void remove(int index) {
        super.remove(index);
        scrollPanesList.remove(index);
    }

    public void addTab(String title, String data) {
        int len = scrollPanesList.size();
        for (int i=0;i<len;i++) {
            if (scrollPanesList.get(i).getTitle().equals(title)) {
                setSelectedIndex(i);
                return ;
            }
        }

        JTextArea textArea = new JTextArea(data);
        JScrollPane scrollPane = new JScrollPane(textArea);
        TabComponent tabComponent = new TabComponent(title,scrollPane);
        ButtonTabComponent buttonTabComponent = new ButtonTabComponent(this);

        scrollPanesList.add(tabComponent);
        int lastIndex = scrollPanesList.indexOf(tabComponent);
        add(tabComponent.getTitle(),scrollPanesList.get(lastIndex).getScrollPane());
        System.out.println(lastIndex);
        setTabComponentAt(lastIndex,buttonTabComponent);

        setSelectedIndex(lastIndex);
    }



}
