package Two.LatterTerm.DataStructurePractice.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByNumeric {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("2");
        list.add("20");
        list.add("10");
        list.add("300");
        list.add("1010");
        list.add("1");
        list.add("100");
        list.add("11");

        System.out.println("ソート前");
        for(String str: list) {
            System.out.println(str);
        }

        Collections.sort(list);

        System.out.println("ソート後");
        for(String str: list) {
            System.out.println(str);
        }

        Collections.sort(list, new NumericComparator());

        System.out.println("順序付けを変更後");
        for (String str: list) {
            System.out.println(str);
        }
    }
}
class NumericComparator implements Comparator<String> {
    // ここを作る
    // Stringのソートは辞書順になるが，
    // 数値順となるように順序付けする
}
