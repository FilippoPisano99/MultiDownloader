package it.filippo.multidownloader;

import java.io.File;

public class DownloadLink {

    enum Status{
        READY,
        DOWNLOADING,
        DONE
    }

    private Status status;

    private String url;
    private String name;
    private String destPath;

    private File destFile;

    public DownloadLink(String url, String name, String dest_path) {
        this.status = Status.READY;
        this.url = url;
        this.name = name;
        this.destPath = dest_path;
    }


    public File getDestFile(){
        if( destFile == null ){
            destFile = new File(destPath +"/"+ name );
        }

        return destFile;
    }

    public void setStatus(Status new_status){
        this.status = new_status;
    }


    public Status getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }


}
