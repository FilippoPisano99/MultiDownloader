package it.filippo.multidownloader;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DownloadManager extends Thread {
    enum Status{
        RUN,
        STOP
    }

    private Status status;
    private ArrayList<DownloadLink> linksToDownload = new ArrayList<>();

    public DownloadManager() {
        this.status = Status.RUN;
    }

    @Override
    public void run() {
        while (status == Status.RUN){
            for (int i = 0; i < linksToDownload.size(); i++) {
                DownloadLink link = linksToDownload.get(i);

                System.out.println(link.getStatus()  + "\t" + link.getName() + "\t" + link.getDestPath());

                if ( link.getStatus() == DownloadLink.Status.READY ){
                    try {
                        System.out.println("\tDownload...");
                        link.setStatus(DownloadLink.Status.DOWNLOADING);
                        FileUtils.copyURLToFile( new URL(link.getUrl()), link.getDestFile() );
                        link.setStatus(DownloadLink.Status.DONE);
                    } catch (IOException e) {
                        status = Status.STOP;
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                }

            }
        }

    }




    public void setStatus( Status new_status ){
        this.status = new_status;
    }

    public void addDownloadLink ( DownloadLink link ){
        this.linksToDownload.add(link);
    }

}
