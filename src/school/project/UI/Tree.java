package school.project.UI;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;
import java.io.FileFilter;

/**
 * Created by forhack on 2016-05-23.
 */
public class Tree extends JTree {
    public Tree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        File rootFile = new File("C:\\");
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(rootFile);
        root.add(node);

        File[] files = rootFile.listFiles(directoryFilter);
        addNodeFile(files,node);

        setModel(treeModel);
        setRootVisible(false);
        expandRow(0);
        //setVisibleRowCount(15);
    }

    private void addNodeFile(File[] file, DefaultMutableTreeNode node) {
        if (file==null) return;
        if (file.length == 0) {
            return ;
        }

        for (int i=0;i<file.length;i++) {
            if (file[i].isDirectory()) {
                DefaultMutableTreeNode inNode = new DefaultMutableTreeNode(file[i].getName());
                node.add(inNode);
                addNodeFile(file[i].listFiles(directoryFilter),inNode);
            }
        }

    }

    private FileFilter directoryFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    };
}
