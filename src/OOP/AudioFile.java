package OOP;

public class AudioFile extends File {
    private int duration;

    public AudioFile(String name, double size, int duration) {
        super(name, size);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}

