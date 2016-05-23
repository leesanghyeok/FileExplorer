package school.project.UI;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;

/**
 * Created by forhack on 2016-05-23.
 */
public class Tree extends JTree {
    public Tree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        File rootFile = new File("C:\\");
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(rootFile);
        root.add( node );

        File[] files = rootFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                node.add(new DefaultMutableTreeNode(file.getName()));
            }
        }


        setModel(treeModel);
        setRootVisible(false);
        expandRow(0);
        setVisibleRowCount(15);
    }

    private File getFileName(File file) {
        String path = file.getPath();
        //file.get
        return null;

    }
}
