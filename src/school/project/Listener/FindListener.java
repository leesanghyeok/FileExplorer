package school.project.Listener;

import school.project.Model.FileData;
import school.project.UI.Dialog.FindDialog;
import school.project.UI.Dialog.WaitDialog;
import school.project.UI.Table;
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

            WaitDialog waitDialog = new WaitDialog();
            waitDialog.setVisible(true);
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getTree().getLastSelectedPathComponent();
            String fileParentPath = FileUtils.treeNodesToString(node.getPath());
            searchFiles(new File(fileParentPath),searchWord);

            table.showFilesTable(fileDataList);
            waitDialog.dispose();
            findDialog.dispose();
        }
    };

    private void searchFiles(File file, String keyWord) {
        File[] files = file.listFiles();
        if (files==null) return;
        int len = files.length;
        if (len == 0) return ;

        for (int i=0;i<len;i++) {
            if (files[i].getName().contains(keyWord)) {
                FileData fileData = new FileData(files[i].isDirectory(),files[i].getName(),files[i].lastModified(),files[i].length());
                fileDataList.add(fileData);
            }
            searchFiles(files[i],keyWord);
        }
    }
}
