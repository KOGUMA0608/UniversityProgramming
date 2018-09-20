package Two.LatterTerm.DataStructurePractice.ex1;

import java.util.ArrayList;

public class Album {
    ArrayList<Music> musiclist = new ArrayList<>();
    private String title;
    private String artist;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Music> getMusiclist() {
        return musiclist;
    }

    public void add(Music music) {
        musiclist.add(music);
    }

    public int getTotalTime() {
        int total = 0;
        for (int i = 0; i < musiclist.size(); i++) {
            total += musiclist.get(i).getTime();
        }
        return total;
    }

    public double getRating() {
        int rating = 0;
        for (int i = 0; i < musiclist.size(); i++) {
            rating += musiclist.get(i).getRating();
        }
        rating /= musiclist.size();
        return rating;
    }

    public void play() {
        /*
        System.out.println(
                "総再生時間:" + getTotalTime()
        );
        System.out.println(
                "アルバム評価;" + getRating()
        );
        */
        System.out.println(
                "アルバム再生中: " + title +
                        " by " + artist + " " +
                        "(" + getMusiclist().size() + "曲," +
                        getTotalTime() + "sec. " +
                        "評価: " + getRating() + ")"
        );


        for (int i = 0; i < musiclist.size(); i++) {
            musiclist.get(i).play();
        }
        System.out.println("再生終了");
    }

    @Override
    public String toString() {
        return "anAlbum(" +
                "" + title +
                ", " + artist +
                ", " + musiclist.size() +
                ", " + getTotalTime() +
                ", " + getRating() +
                ')';
    }

    public static void main(String[] args) {
        Album album = new Album("なんだこれくしょん", "きゃりーぱみゅぱみゅ");
        Music music = new Music("なんだこれくしょん1", "きゃりーぱみゅぱみゅ", 47, 3);
        Music music2 = new Music("なんだこれくしょん2", "きゃりーぱみゅぱみゅ", 47, 3);
        Music music3 = new Music("なんだこれくしょん3", "きゃりーぱみゅぱみゅ", 47, 3);
        album.add(music);
        album.add(music2);
        album.add(music3);

        System.out.println(album);
        System.out.println(
                "総再生時間:" + album.getTotalTime()
        );
        System.out.println(
                "アルバム評価;" + album.getRating()
        );
        album.play();

    }

}

