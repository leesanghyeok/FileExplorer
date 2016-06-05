package school.project.UI;

import school.project.UI.Filter.DirectoryFilter;
import school.project.Util.FileUtils;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;

/**
 * Created by forhack on 2016-05-23.
 */
public class Tree extends JScrollPane {
    JTree tree;
    DirectoryFilter directoryFilter;
    public Tree() {
        tree = new JTree();
        directoryFilter = new DirectoryFilter();
        File rootFile = new File("C:\\");
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootFile);
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        File[] files = rootFile.listFiles(directoryFilter);
        addNodeFile(files,root);

        tree.setModel(treeModel);
        tree.expandRow(0);
        setViewportView(tree);

        tree.addTreeExpansionListener(treeExpansionListener);

    }

    public JTree getTree() {
        return tree;
    }

    private TreeExpansionListener treeExpansionListener = new TreeExpansionListener() {
        @Override
        public void treeExpanded(TreeExpansionEvent event) {
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
            String filePath = FileUtils.treePathToString(event.getPath());
            File file = new File(filePath);
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)event.getPath().getLastPathComponent();
            addNodeFile(file.listFiles(directoryFilter),node);
            model.reload(node);
        }

        @Override
        public void treeCollapsed(TreeExpansionEvent event) {

        }
    };

    //하위디렉토리를 node에 넣고, 하위디렉토리 아래에 디렉토리가 있으면 임시 node를 추가해 준다.
    //나중에 클릭하면 하위디렉토리 출력할 수 있도록
    private void addNodeFile(File[] file, DefaultMutableTreeNode node) {
        if (file==null) return;
        if (file.length == 0) return;
        //if (file.length == 1 && file[0].getName().equals(""))
        node.removeAllChildren();

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

}
