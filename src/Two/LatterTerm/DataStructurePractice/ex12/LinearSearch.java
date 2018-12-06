package Two.LatterTerm.DataStructurePractice.ex12;

import java.io.*;

public class LinearSearch {

    private final int n = 9999;
    private int[] table = new int[n];

    public LinearSearch(String filename) {
        try {
            // ここを作る
            //ファイルを開いて値を取得する
            InputStream data = new FileInputStream(filename);
            InputStreamReader tmp = new InputStreamReader(data);
            BufferedReader reader = new BufferedReader(tmp);
            for (int i = 0; i < n; i++) {
                table[i] = Integer.parseInt(reader.readLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(filename + "が見つかりません。");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void search(int key) {
        // ここを作る
        // 線形探索でkeyを探す
        int i = 0;
        for (int num : table) {
            i++;
            if (key == num) {
                System.out.println(i + "回の探索で" + key + "が見つかりました");
                return;
            }
        }
        System.out.println(key + "は見つかりませんでした");
    }

    public void show() {
        // ここを作る
        // 表の要素を全て表示する
        for (int num : table) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        // 以下の3行のいずれかを使う
        String filename = "rand.txt";
        //String filename = "reverse.txt";
        //String filename = "sorted.txt";

        LinearSearch table = new LinearSearch(filename);
        table.show();
        System.out.println("key=1000を探索");
        table.search(1000);
        System.out.println("key=9412を探索");
        table.search(9412);
        System.out.println("key=2を探索");
        table.search(2);
        System.out.println("key=10000を探索");
        table.search(10000);
    }
}
