package school.project.UI;

import jdk.nashorn.internal.scripts.JD;
import school.project.UI.Dialog.InfoDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by forhack on 2016-05-31.
 */
public class Menu extends JMenuBar {
    JMenu fileMenu;
    JMenu helpMenu;
    JMenuItem fileOpenMenu;
    JMenuItem fileSaveMenu;
    JMenuItem fileExitMenu;
    JMenuItem helpInfoMenu;
    public Menu() {
        fileMenu = new JMenu("FIle(F)");
        helpMenu = new JMenu("Help(H)");
        fileOpenMenu = new JMenuItem("파일 열기");
        fileSaveMenu = new JMenuItem("파일 저장");
        fileExitMenu = new JMenuItem("끝내기");
        helpInfoMenu = new JMenuItem("정보");

        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileOpenMenu.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
        fileSaveMenu.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));

        fileExitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        helpInfoMenu.addActionListener(infoListener);

        fileMenu.add(fileOpenMenu);
        fileMenu.add(fileSaveMenu);
        fileMenu.addSeparator();
        fileMenu.add(fileExitMenu);

        helpMenu.add(helpInfoMenu);

        add(fileMenu);
        add(helpMenu);
    }

    public void setFileOpenListener(ActionListener actionListener) {
        fileOpenMenu.addActionListener(actionListener);
    }

    public void setFileSaveListener(ActionListener actionListener) {
        fileSaveMenu.addActionListener(actionListener);
    }

    private ActionListener infoListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            InfoDialog dialog = new InfoDialog();
            dialog.setVisible(true);
        }
    };

}
