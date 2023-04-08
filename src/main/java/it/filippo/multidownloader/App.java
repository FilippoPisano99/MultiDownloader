package it.filippo.multidownloader;

public class App {

    public void run(){

        DownloadManager downMngr = new DownloadManager();
        downMngr.start();

        downMngr.addDownloadLink(new DownloadLink(
                "https://file-examples.com/storage/fe9278ad7f642dbd39ac5c9/2017/04/file_example_MP4_1920_18MG.mp4",
                "World.mp4",
                "/Users/filippopisano/Desktop/dev/java/downloaded")
        );






    }


}
