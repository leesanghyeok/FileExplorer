package school.project.Util;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.io.File;
import java.util.regex.Matcher;

/**
 * Created by forhack on 2016-06-02.
 */
public class FileUtils {
    public static String treePathToString(TreePath treePath) {
        String filePath = treePath.toString().replaceAll("\\[|\\]","");
        filePath = filePath.replaceAll(", ", Matcher.quoteReplacement(File.separator));
        return filePath;
    }

    public static String treeNodesToString(TreeNode[] treeNodes) {
        int len = treeNodes.length;
        String filePath = "";
        for (int i=0;i<len;i++) {
            filePath += treeNodes[i];
        }
        filePath = filePath.replaceAll(", ", Matcher.quoteReplacement(File.separator));
        return filePath;
    }

}
