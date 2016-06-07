package school.project.Model;

import sun.awt.shell.ShellFolder;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

/**
 * Created by forhack on 2016-06-01.
 */
public class FileData {
    //파일이름 , 수정한 날짜, 파일유형, 크기
    private String name;
    private String lastModified;
    private String type;
    private String size;
    private Icon icon;
    private boolean isDirectory;

    private String directoryStr = "파일 폴더";
    public FileData(boolean isDirectory, String filePath, String name, long lastModified, long size) {
        this.isDirectory = isDirectory;
        setName(name);
        setLastModified(lastModified);
        setSize(size);
        setIcon(filePath);
    }

    public FileData(String name, String lastModified, String type, String size) {
        setDirectory(type);
        this.name = name;
        this.lastModified = lastModified;
        this.type = type;
        this.size = size;
    }

    public String[] toStrings() {
        String [] retStr = {getName(),getLastModified(), getType(),getSize()};
        return retStr;
    }

    private void setDirectory(String directory) {
        isDirectory = directory.equals(directoryStr);
    }

    private void setName(String name) {
        this.name = name;
        //디렉토리는 확장자 설정을 할 필요가 없다.
        if (isDirectory) return;

        int pos = this.name.lastIndexOf( "." );
        String ext = this.name.substring( pos + 1 );
        setType(ext);
    }

    private void setLastModified(long lastModified) {
        Date date = new Date(lastModified);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y-MM-dd a K:mm");
        this.lastModified = simpleDateFormat.format(date);
    }

    private void setSize(long size) {
        //KB단위
        //폴더라면 0을 반환하고.
        if (isDirectory) {
            this.size = "";
            return;
        }

        long retSize = size/1000;
        //파일 사이즈가 너무 작으면 최소 1을 리턴한다.
        if (retSize == 0)
            retSize = 1;

        DecimalFormat df = new DecimalFormat("#,##0");
        this.size  = df.format(retSize) + "KB";
    }

    private void setType(String type) {
        String fileStr = " 파일";
        //입력값이 바로 대입할 값인지, 체크
        if (type.equals(directoryStr) ||
                type.contains(fileStr)) {
            this.type = type;
            return;
        }
        if (isDirectory)
            this.type = directoryStr;
        this.type = type + fileStr;
    }

    public String getLastModified() {
        return lastModified;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        if (isDirectory)
            return directoryStr;
        return type;
    }

    public String getSize() {
        return size;
    }

    public void setIcon(String filePath) {
        try {
            ShellFolder sf = ShellFolder.getShellFolder(new File(filePath));
            Icon ico = new ImageIcon(sf.getIcon(true));
            this.icon = ico;
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
    }

    public Icon getIcon() {
        return icon;
    }
}
