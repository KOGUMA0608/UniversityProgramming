package Two.LatterTerm.DataStructurePractice.ex3;

import java.io.*;

public class SelectionSort {
    private final int n = 50000;
    private int[] array = new int[n];

    public SelectionSort(String filename) {
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
        // 選択ソートを実装する
        // 配列arrayの中身をソートする
        int min;
        int mindir = 0;
        int tali = array.length - 1;
        int change;
        int line;
        for (int i = 0; i < tali; i++) {
            min = array[tali];
            for (int j = 0; j < tali - i; j++) {
                if (min > array[(tali-1) - j]) {
                    min = array[(tali-1) - j];
                    mindir = (tali - 1) - j;
                }
            }
            array[mindir] = array[i];
            array[i] = min;
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
        String file2 = "result_ex3-2_rand2.txt";

        SelectionSort ss = new SelectionSort(file1);
        ss.sort();
        ss.output(file2);
    }
}
