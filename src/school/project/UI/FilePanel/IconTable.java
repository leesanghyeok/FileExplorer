package school.project.UI.FilePanel;

import sun.awt.shell.ShellFolder;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by forhack on 2016-06-06.
 */
public class IconTable extends JScrollPane{
    JPanel mainPanel;
    public IconTable() {
        mainPanel = new JPanel(new FlowLayout());
        File file = new File("C:\\새 폴더\\cdef.txt");
        FileIcon laal = new FileIcon("cdef.txt");
        
        try {
            ShellFolder sf = ShellFolder.getShellFolder(file);
            System.out.println(file.length());
            Icon ico = new ImageIcon(sf.getIcon(true));
            laal.setIcon(ico);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }

        setViewportView(laal);
    }
}
