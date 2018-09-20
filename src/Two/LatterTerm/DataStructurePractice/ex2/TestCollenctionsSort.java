package Two.LatterTerm.DataStructurePractice.ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class TestCollenctionsSort {
    public static void main(String[] args) {
        final int n = 50000;
        ArrayList<String> list = new ArrayList<String>();
        String file1 = "rand2.txt";
        String file2 = "result_ex2-1.txt";
        try {
            InputStream data = new FileInputStream(file1);
            InputStreamReader tmp = new InputStreamReader(data);
            BufferedReader reader = new BufferedReader(tmp);
            String input;
            for (int i = 0; i < n; i++) {
                list.add(input = reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        // file1からデータを入力
        // ここを作る
        // ファイルを開いて全て読み込んでリストlistに入れる
        Collections.sort(list);
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file2)));
            for (int i = 0; i < list.size(); i++) {
                writer.println(list.get(i));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        // file2に結果を出力
        // ここを作る
        // ファイルを開いてリストlistを出力する（1行に1つのデータ）
    }
}
