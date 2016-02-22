package writerreader;

/**
 * Created by toni on 22/02/16.
 */
public class FileInMemory {

    private int lines;
    private String textFile;

    public FileInMemory() {
        textFile = "";
        lines = 0;
    }

    public synchronized int getLines() {
        return lines;
    }

    public synchronized String read(){
        return textFile;
    }

    public synchronized void writer(String line){
        textFile += line + "\n";
        lines++;
    }
}
