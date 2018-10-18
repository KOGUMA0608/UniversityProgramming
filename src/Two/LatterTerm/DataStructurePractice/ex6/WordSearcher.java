package Two.LatterTerm.DataStructurePractice.ex6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSearcher {
    Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        WordSearcher ws = new WordSearcher();
        ws.insert();
        while (true) {
            System.out.println("英単語を入力してください．");
            Scanner scan = new Scanner(System.in);
            String input = scan.next();
            if (input.equals("exit")) {
                System.out.println("終了します。");
                System.exit(0);
            } else {
                ws.search(input);
            }
        }
    }

    public void insert() {
        map.put("tomato", "トマト");
        map.put("strawberry", "苺");
        map.put("orange", "蜜柑");
        map.put("onion", "玉葱");
        map.put("apple", "林檎");
        map.put("banana", "バナナ");
    }

    public void search(String input) {
        if (map.containsKey(input)) {
            System.out.println(input + "の意味は" + map.get(input) + "です。");
        } else {
            System.out.println(input + "はデータベース上に存在していない!");
        }
    }
}
