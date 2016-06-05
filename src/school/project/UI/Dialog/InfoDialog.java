package school.project.UI.Dialog;

import javax.swing.*;
import java.awt.*;

/**
 * Created by forhack on 2016-06-05.
 */
public class InfoDialog extends JDialog {
    JPanel panel;
    JLabel textEncoding;
    public InfoDialog() {
        panel = new JPanel(new BorderLayout());
        textEncoding = new JLabel("본 프로그램은 UTF-8 문서만 정상적으로 열립니다.");
        setSize(300,100);
        setLocationRelativeTo(null);
        setTitle("도움말");

        panel.add(textEncoding,BorderLayout.CENTER);
        add(panel);
    }
}
