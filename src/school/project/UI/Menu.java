package school.project.UI;

import javax.swing.*;

/**
 * Created by forhack on 2016-05-31.
 */
public class Menu extends JMenuBar {
    JMenu fileMenu;
    public Menu() {
        fileMenu = new JMenu("FIle");
        fileMenu.add(new JMenuItem("파일 열기"));
        fileMenu.add(new JMenuItem("파일 저장"));

        add(fileMenu);
    }
}
