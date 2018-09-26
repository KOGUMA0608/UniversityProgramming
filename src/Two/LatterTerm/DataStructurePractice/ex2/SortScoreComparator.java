package Two.LatterTerm.DataStructurePractice.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class SortScoreComparator {
    public static void main(String[] args) {
        ArrayList<Score2> score = new ArrayList<Score2>();

        score.add(new Score2("taro", 12, 97));
        score.add(new Score2("jiro", 42, 54));
        score.add(new Score2("sabu", 42, 47));
        score.add(new Score2("siro", 57, 97));
        score.add(new Score2("goro", 87, 40));
        score.add(new Score2("roku", 99, 99));
        score.add(new Score2("nana", 14, 23));
        score.add(new Score2("hati", 42, 54));

        System.out.println("ソート前");
        for (Score2 s : score) {
            System.out.println(s.getName() + " : Math: " + s.getMath() + " : English : " + s.getEnglish());
        }

        Collections.sort(score, new ScoreComparator());


        System.out.println("ソート後");
        for (Score2 s : score) {
            System.out.println(s.getName() + " : Math: " + s.getMath() + " : English : " + s.getEnglish());
        }
    }
}

class Score2 {
    private String name;
    private int math;
    private int english;

    public Score2(String name, int math, int english) {
        this.name = name;
        this.math = math;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public int getMath() {
        return math;
    }

    public int getEnglish() {
        return english;
    }
}

class ScoreComparator implements Comparator<Score2> {
    private Integer math;
    private Integer opponentsmath;
    private Integer english;
    private Integer opponentsenglish;

    // ここを作る
    // 順序付けは以下の通り
    // 1. 数学が良い順とする
    // 2. 数学が同点の場合は英語が良い順
    // 3. それでも順位が付かない場合は同位とする
    public int compare(Score2 input, Score2 opponentinput) {
        math = (Integer) input.getMath();
        opponentsmath = (Integer) opponentinput.getMath();
        return math.compareTo(opponentsmath);
        if (Objects.equals(math, opponentsmath)) {
            english = (Integer) input.getEnglish();
            opponentsenglish = (Integer) opponentinput.getEnglish();
            return english.compareTo(opponentsenglish);
        }
    }
}