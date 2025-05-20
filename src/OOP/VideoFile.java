package OOP;

public class VideoFile extends File {
    private int width, height;
    private int duration;

    public VideoFile(String name, double size, int width, int height, int duration) {
        super(name, size);
        this.width = width;
        this.height = height;
        this.duration = duration;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDuration() {
        return duration;
    }
}

