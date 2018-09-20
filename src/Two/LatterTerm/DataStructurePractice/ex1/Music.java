package Two.LatterTerm.DataStructurePractice.ex1;

public class Music {
    private String title;
    private String artist;
    private int time;
    private int rating;

    public Music(String title, String artist, int time, int rating) {
        this.title = title;
        this.artist = artist;
        this.time = time;
        this.rating = rating;
    }

    public static void main(String[] args) {
        Music music = new Music("なんだこれくしょん", "きゃりーぱみゅぱみゅ", 47, 3);
        System.out.println(music);
        music.play();
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getTime() {
        return time;
    }

    public int getRating() {
        return rating;
    }

    public void play() {

        System.out.println(
                "再生中: " + title +
                        " by " + artist + " " +
                        time + " sec., " +
                        "Fav: " + rating
        );
    }

    @Override
    public String toString() {
        return "aMusic(" +
                title +
                ", " + artist +
                ", " + time +
                ", " + rating +
                ')';
    }
}
