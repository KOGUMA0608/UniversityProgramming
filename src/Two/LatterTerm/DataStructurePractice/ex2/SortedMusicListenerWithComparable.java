package Two.LatterTerm.DataStructurePractice.ex2;

import java.util.ArrayList;
import java.util.Collections;

public class SortedMusicListenerWithComparable {
    public static void main(String[] args) {
        ArrayList<Music> album = new ArrayList<Music>();

        album.add(new Music("Technopolis", "Yellow Magic Orchestra"));
        album.add(new Music("Absolute Ego Dance", "Yellow Magic Orchestra"));
        album.add(new Music("Rydeen", "Yellow Magic Orchestra"));
        album.add(new Music("Castalia", "Yellow Magic Orchestra"));
        album.add(new Music("Behind the Mask", "Yellow Magic Orchestra"));
        album.add(new Music("Day Tripper", "Yellow Magic Orchestra"));
        album.add(new Music("Insomnia", "Yellow Magic Orchestra"));
        album.add(new Music("Solid State Survivor", "Yellow Magic Orchestra"));

        Collections.sort(album);

        for (Music music : album) {
            System.out.println(music.getTitle() + " by " + music.getArtist());
        }
    }
}
class Music implements Comparable<Music> {
    private String title;
    private String artist;

    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    // タイトルで比較
    public int compareTo(Music another) {
        String anotherTitle = another.getTitle();
        if (title.compareTo(anotherTitle) < 0) {
            // 自分が相手よりも前
            return -1;
        } else if (title.compareTo(anotherTitle) > 0) {
            // 自分が相手よりも後
            return 1;
        } else {
            // それ以外＝同一順位
            return 0;
        }
    }
}
