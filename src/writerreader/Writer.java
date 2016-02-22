package writerreader;

/**
 * Created by toni on 22/02/16.
 */
public class Writer extends Thread{
    private FileInMemory file;

    public Writer(String name, FileInMemory file){
        super(name);
        this.file = file;
    }

    @Override
    public void run() {

    }
}
