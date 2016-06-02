package school.project.Model;

import javax.swing.*;

/**
 * Created by forhack on 2016-06-02.
 */
public class TabComponent {
    private String title;
    private JScrollPane scrollPane;

    public TabComponent(String title, JScrollPane scrollPane) {
        this.title = title;
        this.scrollPane = scrollPane;
    }

    public JScrollPane getScrollPane() {

        return scrollPane;
    }

    public String getTitle() {

        return title;
    }
}
