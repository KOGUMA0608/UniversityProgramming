package Two.LatterTerm.DataStructurePractice.ex3;

import java.io.*;

public class InsertionSort {
    private final int n = 50000;
    private int[] array = new int[n];

    public InsertionSort(String filename) {
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
        // 挿入ソートを実装する
        // 配列arrayの中身をソートする
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < i+1; j++) {
                if (array[(i + 1) - j] < array[i - j]) {
                    temp = array[i - j];
                    array[i - j] = array[i + 1 - j];
                    array[i + 1 - j] = temp;
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
        String file2 = "result_ex3-3_rand2.txt";

        InsertionSort is = new InsertionSort(file1);
        is.sort();
        is.output(file2);
    }
}

