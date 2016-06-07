package school.project.UI.FilePanel;

import javax.swing.*;

/**
 * Created by forhack on 2016-06-07.
 */
public class FileIcon extends JLabel {
    public FileIcon() {
    }

    public FileIcon(String text, Icon icon) {
        setText(text);
        setIcon(icon);
        setVerticalTextPosition(JLabel.BOTTOM);
        setHorizontalTextPosition(JLabel.CENTER);
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

}
