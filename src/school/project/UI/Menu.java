package school.project.UI;

import school.project.UI.Dialog.InfoDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by forhack on 2016-05-31.
 */
public class Menu extends JMenuBar {
    private static final int LINK_INDEX = 3;
    JMenu fileMenu;
    JMenu helpMenu;
    JMenu editMenu;
    JMenuItem fileOpenMenu;
    JMenuItem fileSaveMenu;
    JMenuItem fileExitMenu;
    JMenuItem helpInfoMenu;
    JMenuItem editFindMenu;

    ActionListener linkFileOpenListener;

    ArrayList<JMenuItem> menuItemList;

    public Menu(ActionListener linkFileListener) {
        this.linkFileOpenListener = linkFileListener;
        fileMenu = new JMenu("FIle(F)");
        helpMenu = new JMenu("Help(H)");
        editMenu = new JMenu("Edit(E)");
        fileOpenMenu = new JMenuItem("파일 열기");
        fileSaveMenu = new JMenuItem("파일 저장");
        fileExitMenu = new JMenuItem("끝내기");
        helpInfoMenu = new JMenuItem("정보");
        editFindMenu = new JMenuItem("검색");

        menuItemList = new ArrayList<JMenuItem>();

        fileMenu.setMnemonic(KeyEvent.VK_F);
        helpMenu.setMnemonic(KeyEvent.VK_H);
        editMenu.setMnemonic(KeyEvent.VK_E);
        fileOpenMenu.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
        fileSaveMenu.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));
        editFindMenu.setAccelerator(KeyStroke.getKeyStroke('F', Event.CTRL_MASK));

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
        fileMenu.addSeparator();
        fileMenu.add(fileExitMenu);

        editMenu.add(editFindMenu);

        helpMenu.add(helpInfoMenu);

        add(fileMenu);
        add(editMenu);
        add(helpMenu);

    }

    public void addLinkMenu(String title) {
        //등록되어있는 것중 같은 것이 있것을 골라낸다.
        int len = menuItemList.size();
        for (int i=0;i<len;i++) {
            if (menuItemList.get(i).getText().equals(title)) {
                removeLinkMenu(i);
                break;
            }
        }

        JMenuItem item = new JMenuItem(title);
        menuItemList.add(item);
        fileMenu.add(item, LINK_INDEX);
        item.addActionListener(linkFileOpenListener);
    }

    private void removeLinkMenu(int index) {
        fileMenu.remove(LINK_INDEX+index);
        menuItemList.remove(index);
    }

    public void setFileOpenListener(ActionListener actionListener) {
        fileOpenMenu.addActionListener(actionListener);
    }

    public void setFileSaveListener(ActionListener actionListener) {
        fileSaveMenu.addActionListener(actionListener);
    }

    public void setFindListener(ActionListener actionListener) {
        editFindMenu.addActionListener(actionListener);
    }

    private ActionListener infoListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            InfoDialog dialog = new InfoDialog();
            dialog.setVisible(true);
        }
    };

}
