package school.project.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by forhack on 2016-06-01.
 */
public class FileSaveListener {
    public void fileSave(File file, String data) {
        FileWriter writer;
        try {
            writer = new FileWriter(file);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.getStackTrace();
            return;
        }
    }
}
