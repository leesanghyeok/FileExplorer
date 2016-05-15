package school.project;

import javax.swing.*;
import java.awt.*;

/**
 * Created by forhack on 2016-05-16.
 */
public class StartWindow extends JFrame{
    public StartWindow() throws HeadlessException {
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Explorer");
        setVisible(true);
    }
}
