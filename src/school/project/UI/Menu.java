package school.project.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by forhack on 2016-05-31.
 */
public class Menu extends JMenuBar {
    JMenu fileMenu;
    JMenuItem fileOpenMenu;
    JMenuItem fileSaveMenu;
    public Menu() {
        fileMenu = new JMenu("FIle");
        fileOpenMenu = new JMenuItem("파일 열기");
        fileSaveMenu = new JMenuItem("파일 저장");
        fileMenu.add(fileOpenMenu);
        fileMenu.add(fileSaveMenu);

        add(fileMenu);
    }

    public void setFileOpenListener(ActionListener actionListener) {
        fileOpenMenu.addActionListener(actionListener);
    }

    public void setFileSaveListener(ActionListener actionListener) {
        fileSaveMenu.addActionListener(actionListener);
    }

}
