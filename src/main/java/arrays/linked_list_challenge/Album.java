package arrays.linked_list_challenge;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        return songs.stream()
                .filter(song -> title.equals(song.getTitle()))
                .findAny().orElse(null);
    }

    public boolean addToPlayList(int trackNumber, List<Song> playList) {
        int index = trackNumber - 1;
        if (index >= 0 && index <= songs.size()) {
            playList.add(songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track: " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, List<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song: " + title + " is not in this album");
        return false;
    }
}
