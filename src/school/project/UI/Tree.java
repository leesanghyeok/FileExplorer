package school.project.UI;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;
import java.io.FileFilter;

/**
 * Created by forhack on 2016-05-23.
 */
public class Tree extends JScrollPane {
    JTree tree;
    public Tree() {
        tree = new JTree();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        File rootFile = new File("C:\\");
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(rootFile);
        root.add(node);

        File[] files = rootFile.listFiles(directoryFilter);
        addNodeFile(files,node);

        tree.setModel(treeModel);
        tree.setRootVisible(false);
        tree.expandRow(0);
        setViewportView(tree);
        //setVisibleRowCount(15);
    }

    //하위디렉토리를 node에 넣고, 하위디렉토리 아래에 디렉토리가 있으면 임시 node를 추가해 준다.
    //나중에 클릭하면 하위디렉토리 출력할 수 있도록
    private void addNodeFile(File[] file, DefaultMutableTreeNode node) {
        if (file==null) return;
        if (file.length == 0) return;

        for (int i=0;i<file.length;i++) {
            if (file[i].listFiles(directoryFilter)==null) continue;
            if (file[i].isDirectory()) {
                DefaultMutableTreeNode inNode = new DefaultMutableTreeNode(file[i].getName());
                node.add(inNode);
                int len = file[i].listFiles(directoryFilter).length;
                if (len != 0) {
                    inNode.add(new DefaultMutableTreeNode());
                }
            }
        }
    }


    //한번에 모든 폴더들을 node에 add하는 재귀함수.
    private void addAllNodeFile(File[] file, DefaultMutableTreeNode node) {
        if (file==null) return;
        if (file.length == 0) {
            return ;
        }

        for (int i=0;i<file.length;i++) {
            if (file[i].isDirectory()) {
                DefaultMutableTreeNode inNode = new DefaultMutableTreeNode(file[i].getName());
                node.add(inNode);
                addAllNodeFile(file[i].listFiles(directoryFilter),inNode);
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
