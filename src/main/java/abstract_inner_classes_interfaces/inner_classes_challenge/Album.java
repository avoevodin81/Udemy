package abstract_inner_classes_interfaces.inner_classes_challenge;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
//    private List<Song> songs;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
//        songs = new ArrayList<>();
        songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songs.add(new Song(title, duration));
//        if (findSong(title) == null) {
//            songs.add(new Song(title, duration));
//            return true;
//        }
//        return false;
    }

//    private Song findSong(String title) {
//        return songs.stream()
//                .filter(song -> title.equals(song.getTitle()))
//                .findAny().orElse(null);
//    }

    public boolean addToPlayList(int trackNumber, List<Song> playList) {
//        int index = trackNumber - 1;
//        if (index >= 0 && index <= songs.size()) {
//            playList.add(songs.get(index));
//            return true;
//        }
        Song checkedSong = songs.findSong(trackNumber);
        if (checkedSong != null) {
            playList.add(checkedSong);
        }
        System.out.println("This album does not have a track: " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, List<Song> playList) {
//        Song checkedSong = findSong(title);
        Song checkedSong = songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song: " + title + " is not in this album");
        return false;
    }

    private class SongList {
        private List<Song> songs;

        public SongList() {
            songs = new ArrayList<>();
        }

        public boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            songs.add(song);
            return true;
        }

        private Song findSong(String title) {
            return songs.stream()
                    .filter(song -> title.equals(song.getTitle()))
                    .findAny().orElse(null);
        }

        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index >= 0 && index < songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }
}
