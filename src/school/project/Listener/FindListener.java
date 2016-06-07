package school.project.Listener;

import school.project.Model.FileData;
import school.project.UI.Dialog.FindDialog;
import school.project.UI.Dialog.WaitDialog;
import school.project.UI.FilePanel.Table;
import school.project.UI.Tree;
import school.project.Util.FileUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by forhack on 2016-06-05.
 */
public class FindListener implements ActionListener {
    FindDialog findDialog;
    Table table;
    Tree tree;

    ArrayList<FileData> fileDataList;

    public FindListener(Table table, Tree tree) {
        this.table = table;
        this.tree = tree;
    }

    public void actionPerformed(ActionEvent e) {
        findDialog = new FindDialog();
        findDialog.setVisible(true);
        findDialog.addConfirmListener(searchConfirmActionListener);
    }

    private ActionListener searchConfirmActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchWord = findDialog.getSearchWord();
            String optionWord = findDialog.getOptionWord();
            fileDataList = new ArrayList<FileData>();

            if (searchWord.equals("")) {
                JOptionPane.showMessageDialog(null, "검색어를 입력하세요.", "Message", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //기다려 메시지 띄우기
            WaitDialog waitDialog = new WaitDialog();
            waitDialog.setVisible(true);

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getTree().getLastSelectedPathComponent();
            String fileParentPath = FileUtils.treeNodesToString(node.getPath());
            searchFiles(new File(fileParentPath),searchWord, optionWord);

            table.showFilesTable(fileDataList);
            waitDialog.dispose();
            findDialog.dispose();
        }
    };

    private boolean doFilter(File file, String option, String keyWord) {
        if (option.equals(FindDialog.OPTION_ALL)) {
            return file.getName().contains(keyWord);
        } else if (option.equals(FindDialog.OPTION_DIRECTORY)) {
            if (file.getName().contains(keyWord))
                return file.isDirectory();
            else
                return false;
        } else if (option.equals(FindDialog.OPTION_FILE)) {
            if (file.getName().contains(keyWord))
                return file.isFile();
            else
                return false;
        } else if (option.equals(FindDialog.OPTION_EXT)) {
            int pos = file.getName().lastIndexOf( "." );
            String ext = file.getName().substring( pos + 1 );
            return ext.equals(keyWord);

        } else if (option.equals(FindDialog.OPTION_SIZE)) {
            if (file.isDirectory()) return false;
            long keyValue=0;
            try {
                keyValue = Integer.valueOf(keyWord.substring(1));
                keyValue*=1000;
            } catch (NumberFormatException e) {
                return false;
            };

            char flag = keyWord.charAt(0);
            //첫글자가 +또는 -여야 한다.
            if (flag=='+') {
                return (file.length() > keyValue);
            }else if (flag=='-') {
                return (file.length() < keyValue);
            }else
                return false;

        } else {
            return false;
        }
    }

    private void addFileToList(File file, String keyWord, String optionWord) {
        if (doFilter(file,optionWord,keyWord)) {
            FileData fileData = new FileData(file.isDirectory(),file.getAbsolutePath(), file.getAbsolutePath(),file.lastModified(),file.length());
            fileDataList.add(fileData);
        }
    }

    private void searchFiles(File file, String keyWord, String optionWord) {
        File[] files = file.listFiles();
        if (files==null) return;
        int len = files.length;
        if (len == 0) return ;

        for (int i=0;i<len;i++) {
            addFileToList(files[i],keyWord,optionWord);
            searchFiles(files[i],keyWord,optionWord);
        }
    }
}
