package school.project.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by forhack on 2016-06-01.
 */
public class FileData {
    //파일이름 , 수정한 날짜, 파일유형, 크기
    private String name;
    private long lastModified;
    private String ext;
    private long size;
    private boolean isDirectory;

    public FileData(boolean isDirectory, String name, long lastModified, long size) {
        this.isDirectory = isDirectory;
        setName(name);
        this.lastModified = lastModified;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
        //디렉토리는 확장자 설정을 할 필요가 없다.
        if (isDirectory) return;

        int pos = name.lastIndexOf( "." );
        String ext = name.substring( pos + 1 );
        this.ext = ext;
    }

    public String getLastModified() {
        Date date = new Date(lastModified);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y-MM-dd a K:mm");
        return simpleDateFormat.format(date);
    }

    public String getName() {
        return name;
    }

    public String getExt() {
        if (isDirectory)
            return "파일 폴더";
        return ext + "파일";
    }

    public String getSize() {
        //KB단위
        //폴더라면 0을 반환하고.
        if (isDirectory)
            return "";

        long retSize = size/1000;
        //파일 사이즈가 너무 작으면 최소 1을 리턴한다.
        if (retSize == 0)
            retSize = 1;
        return retSize + "KB";
    }
}
