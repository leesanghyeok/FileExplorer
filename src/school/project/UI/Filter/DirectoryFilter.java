package school.project.UI.Filter;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by forhack on 2016-06-05.
 */
public class DirectoryFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }
}
