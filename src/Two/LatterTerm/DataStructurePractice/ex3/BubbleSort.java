package Two.LatterTerm.DataStructurePractice.ex3;

import java.io.*;

public class BubbleSort {
    private final int n = 50000;
    private int[] array = new int[n];

    public BubbleSort(String filename) {
        // ここを作る
        // ファイル名を引数とする
        // ファイルを開いて全て読み込んで配列arrayに入れる
        try {
            InputStream data = new FileInputStream(filename);
            InputStreamReader tmp = new InputStreamReader(data);
            BufferedReader reader = new BufferedReader(tmp);
            String input;
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void sort() {
        // ここを作る
        // バブルソートを実装する
        // 配列arrayの中身をソートする
        int comp;
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - (i + 1); j++) {
                comp = array[array.length - (j + 2)];
                temp = array[array.length - (j + 1)];
                if (temp < comp) {
                    array[array.length - (j + 2)] = temp;
                    array[array.length - (j + 1)] = comp;
                } else {

                }
            }
        }
    }

    public void output(String filename) {
        // ここを作る
        // ファイル名を引数とする
        // 配列arrayをファイルに出力する
        // 1行に1レコード
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            for (int i = 0; i < n; i++) {
                writer.println(String.valueOf(array[i]));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String file1 = "rand2.txt";
        String file2 = "result_ex3-1_rand2.txt";

        BubbleSort bs = new BubbleSort(file1);
        bs.sort();
        bs.output(file2);
    }
}
