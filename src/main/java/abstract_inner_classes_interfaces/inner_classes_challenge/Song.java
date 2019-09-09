package abstract_inner_classes_interfaces.inner_classes_challenge;

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
//        return "Song{" +
//                "title='" + title + '\'' +
//                ", duration=" + duration +
//                '}';
        return title + ": " + duration;
    }
}
