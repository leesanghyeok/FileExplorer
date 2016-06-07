package school.project.UI.FilePanel;

import school.project.Model.FileData;
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
        setViewportView(mainPanel);

        File f = new File("C:\\새 폴더");
        showFiles(f.listFiles());

    }

    public void addFile(FileData fileData) {
        FileIcon laal = new FileIcon(fileData.getName(), fileData.getIcon());
        mainPanel.add(laal);
    }

    public void showFiles(File[] files) {
        //기존 테이블 삭제
        Clear();
        int len = files.length;
        for (int i=0;i<len;i++) {
            FileData fileData = new FileData(files[i].isDirectory(), files[i].getAbsolutePath(),
                    files[i].getName(),files[i].lastModified(),files[i].length());
            addFile(fileData);
        }
    }

    public void Clear() {
        mainPanel.removeAll();
    }
}
