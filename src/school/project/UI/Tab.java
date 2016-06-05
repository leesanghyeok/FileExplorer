package school.project.UI;

import school.project.Model.TabComponent;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by forhack on 2016-05-23.
 */
public class Tab extends JTabbedPane {
    private ArrayList<TabComponent> scrollPanesList = new ArrayList<TabComponent>();

    public ArrayList<TabComponent> getScrollPanesList() {
        return scrollPanesList;
    }

    @Override
    public void remove(int index) {
        super.remove(index);
        scrollPanesList.remove(index);
    }

    public void addTab(String title, String data) {
        int len = scrollPanesList.size();
        //이미 있는 tab 체크하기
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
        setTabComponentAt(lastIndex,buttonTabComponent);
        setSelectedIndex(lastIndex);
    }



}
