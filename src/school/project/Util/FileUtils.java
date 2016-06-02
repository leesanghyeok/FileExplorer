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

    public static String getFileData(String path) {
        BufferedReader reader = null;
        String fileData = "";
        try {
            reader = new BufferedReader(new FileReader(path));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                fileData+=line+"\r\n"n;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }

        return fileData;
    }

}
