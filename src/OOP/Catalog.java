package OOP;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String name;
    private List<File> files;

    public Catalog(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public int countAudioFiles(){
        int count = 0;
        for (File file : files) {
            if (file instanceof AudioFile) {
                count++;
            }
        }
        return count;
    }

    public int countVideoFiles(){
        int count = 0;
        for (File file : files) {
            if (file instanceof VideoFile) {
                count++;
            }
        }
        return count;
    }
}