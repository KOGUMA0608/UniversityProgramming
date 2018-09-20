package Two.LatterTerm.DataStructurePractice.ex1;

import java.util.ArrayList;
import java.util.Collections;

public class MusicPlayer {
    ArrayList<Album> albumlist = new ArrayList<>();
    private String name;

    public MusicPlayer(String name) {
        this.name = name;
    }

    public void add(Album album) {
        albumlist.add(album);
    }

    public void play() {
        System.out.println("Walkmanで全曲再生");
        for (int i = 0; i < albumlist.size(); i++) {
            albumlist.get(i).play();
        }
    }

    public void shufflePlay(MusicPlayer musicPlayer) {
        System.out.println("Walkmanでランダム再生");
        Collections.shuffle(Collections.singletonList(musicPlayer));
        for (int i = 0; i < albumlist.size(); i++) {
            albumlist.get(i).play();
        }
    }

    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer("Walkman");
        //アルバム
        Album album = new Album("なんだこれくしょん", "きゃりーぱみゅぱみゅ");
        Music music = new Music("なんだこれくしょん1", "きゃりーぱみゅぱみゅ", 47, 3);
        Music music2 = new Music("なんだこれくしょん2", "きゃりーぱみゅぱみゅ", 47, 3);
        Music music3 = new Music("なんだこれくしょん3", "きゃりーぱみゅぱみゅ", 47, 3);
        album.add(music);
        album.add(music2);
        album.add(music3);
        //アルバム終了
        musicPlayer.add(album);
        musicPlayer.play();
        musicPlayer.shufflePlay(musicPlayer);
    }
}
