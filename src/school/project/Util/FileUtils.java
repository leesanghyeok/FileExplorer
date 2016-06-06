package school.project.Util;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.io.*;
import java.util.regex.Matcher;

/**
 * Created by forhack on 2016-06-02.
 */
public class FileUtils {
    public static String treePathToString(TreePath treePath) {
        try {
            String filePath = treePath.toString().replaceAll("\\[|\\]","");
            filePath = filePath.replaceAll(", ", Matcher.quoteReplacement(File.separator));
            return filePath;
        } catch (NullPointerException e) {
            return "";
        }
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

    public static String getFileData(File path) {
        StringBuffer fileData = new StringBuffer();
        try {
            FileInputStream fin = new FileInputStream(path);
            InputStreamReader in = new InputStreamReader(fin, "UTF-8");
            int c;
            while ((c = in.read()) != -1) {
                fileData.append((char)c);
            }
            fin.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return fileData.toString();
    }

}
