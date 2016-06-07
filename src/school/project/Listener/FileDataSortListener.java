package school.project.Listener;

import school.project.Model.FileData;
import school.project.UI.FilePanel.Table;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by forhack on 2016-06-05.
 */
public class FileDataSortListener extends MouseAdapter {
    Table table;
    private ArrayList<FileData> fileDataLists;

    int nameSortFlag;
    int lastModifiedSortFlag;
    int typeSortFlag;
    int sizeSortFlag;
    public FileDataSortListener(Table table) {
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = table.getTable().columnAtPoint(e.getPoint());
        collectFileData();
        switch (col) {
            case Table.COLUMN_NAME:
                sortName();
                break;
            case Table.COLUMN_LAST_MODIFIED:
                sortLastModified();
                break;
            case Table.COLUMN_TYPE:
                sortType();
                break;
            case Table.COLUMN_SIZE:
                sortSize();
                break;
            default:
                break;
        }
    }

    private void collectFileData() {
        fileDataLists = new ArrayList<FileData>();
        DefaultTableModel model = table.getModel();
        int rowLen = model.getRowCount();
        for (int i=0;i<rowLen;i++) {
            String name = (String)model.getValueAt(i,Table.COLUMN_NAME);
            String lastModified = (String)model.getValueAt(i,Table.COLUMN_LAST_MODIFIED);
            String type = (String)model.getValueAt(i,Table.COLUMN_TYPE);
            String size = (String)model.getValueAt(i,Table.COLUMN_SIZE);
            FileData fileData = new FileData(name,lastModified,type,size);
            fileDataLists.add(fileData);
        }
    }

    private int toggleSortFlag(int sortFlag) {
        if (sortFlag == 1)
            return 0;
        else
            return 1;
    }

    public void sortName() {
        nameSortFlag = toggleSortFlag(nameSortFlag);
        Collections.sort(fileDataLists, new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                if (nameSortFlag == 1)
                    return o1.getName().compareTo(o2.getName());
                else
                    return o2.getName().compareTo(o1.getName());
            }
        });
        table.Clear();
        table.showFilesTable(fileDataLists);
    }

    public void sortLastModified() {
        lastModifiedSortFlag = toggleSortFlag(lastModifiedSortFlag);
        Collections.sort(fileDataLists, new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                if (lastModifiedSortFlag == 1)
                    return o1.getLastModified().compareTo(o2.getLastModified());
                else
                    return o2.getLastModified().compareTo(o1.getLastModified());
            }
        });
        table.Clear();
        table.showFilesTable(fileDataLists);
    }

    public void sortType() {
        typeSortFlag = toggleSortFlag(typeSortFlag);
        Collections.sort(fileDataLists, new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                if (typeSortFlag == 1)
                    return o1.getType().compareTo(o2.getType());
                else
                    return o2.getType().compareTo(o1.getType());
            }
        });
        table.Clear();
        table.showFilesTable(fileDataLists);
    }

    public void sortSize() {
        sizeSortFlag= toggleSortFlag(sizeSortFlag);
        Collections.sort(fileDataLists, new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                if (sizeSortFlag == 1)
                    return o1.getSize().compareTo(o2.getSize());
                else
                    return o2.getSize().compareTo(o1.getSize());
            }
        });
        table.Clear();
        table.showFilesTable(fileDataLists);
    }
}