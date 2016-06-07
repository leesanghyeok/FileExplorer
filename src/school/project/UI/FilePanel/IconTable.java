package school.project.UI.FilePanel;

import school.project.Model.FileData;
import school.project.UI.WrapLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by forhack on 2016-06-06.
 */
public class IconTable extends JScrollPane{
    JPanel mainPanel;
    public IconTable() {
        mainPanel = new JPanel(new WrapLayout(FlowLayout.LEFT));
        mainPanel.setBackground(Color.white);
        setViewportView(mainPanel);

    }

    @Override
    public Component getComponentAt(int x, int y) {
        return mainPanel.getComponentAt(x, y);
    }

    @Override
    public Component getComponentAt(Point p) {
        return mainPanel.getComponentAt(p);
    }

    public void addFile(FileData fileData, MouseListener mouseAdapter) {
        FileIcon fileIcon = new FileIcon(fileData.getName(), fileData.getIcon());
        fileIcon.addMouseListener(mouseAdapter);
        mainPanel.add(fileIcon);
    }

    public void showFiles(File[] files, MouseListener mouseAdapter) {
        //기존 테이블 삭제
        Clear();
        int len = files.length;
        for (int i=0;i<len;i++) {
            FileData fileData = new FileData(files[i].isDirectory(), files[i].getAbsolutePath(),
                    files[i].getName(),files[i].lastModified(),files[i].length());
            addFile(fileData, mouseAdapter);
        }
        rePaint();
    }

    public void showFiles(ArrayList<FileData> files, MouseListener mouseAdapter) {
        //기존 테이블 삭제
        Clear();
        int len = files.size();
        for (int i=0;i<len;i++) {
            FileData fileData = files.get(i);
            addFile(fileData, mouseAdapter);
        }
        rePaint();
    }

    public void Clear() {
        mainPanel.removeAll();
        rePaint();
    }

    private void rePaint() {
        mainPanel.revalidate();
        mainPanel.repaint();   // This is required in some cases
    }
}
