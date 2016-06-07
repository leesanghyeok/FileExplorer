package school.project.UI.FilePanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by forhack on 2016-06-07.
 */
public class FileIcon extends JLabel {
    public FileIcon() {
    }

    public FileIcon(String text, Icon icon) {
        setOpaque(true);
        setBackground(Color.white);
        setText(text);
        setIcon(icon);
        setVerticalTextPosition(JLabel.BOTTOM);
        setHorizontalTextPosition(JLabel.CENTER);
        setPreferredSize(new Dimension(80,80));

        addMouseListener(new IconHoverListener());
    }

    public FileIcon(Icon icon, String text) {
        this(text,icon);
    }

    public FileIcon(String text) {
        this(text,null);
    }

    public FileIcon(Icon icon) {
        this(null,icon);
    }

    class IconHoverListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            setBackground(Color.cyan);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setBackground(Color.white);
        }
    }


}
