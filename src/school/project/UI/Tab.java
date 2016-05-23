package school.project.UI;

import javax.swing.*;

/**
 * Created by forhack on 2016-05-23.
 */
public class Tab extends JTabbedPane {
    public Tab() {
        JPanel first = new JPanel();
        JPanel second = new JPanel();
        add("first",first);
        add("second",second);
    }
}
