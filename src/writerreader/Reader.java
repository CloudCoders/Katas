package writerreader;

/**
 * Created by toni on 22/02/16.
 */
public class Reader extends Thread {
    private FileInMemory file;

    public Reader(String name, FileInMemory file){
        super(name);
        this.file = file;
    }

    @Override
    public void run() {

    }
}
