package OOP;

public class CatalogTest {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("catalog");

        catalog.addFile(new AudioFile("Audio", 1024, 5));
        catalog.addFile(new VideoFile("Video", 2048, 1920, 1080, 2));

        System.out.println(catalog.countAudioFiles());
        System.out.println(catalog.countVideoFiles());
    }
}
