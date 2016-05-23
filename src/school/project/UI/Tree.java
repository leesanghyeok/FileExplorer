package school.project.UI;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Created by forhack on 2016-05-23.
 */
public class Tree extends JTree {
    public Tree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode rrr = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode r11r = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode rr = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode rrr1 = new DefaultMutableTreeNode("root");
        root.add(rrr);
        root.add(r11r);
        rrr.add(rr);
        rr.add(rrr1);
        DefaultTreeModel model = new DefaultTreeModel(root);
        this.setModel(model);
    }
}
