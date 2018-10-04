package Two.LatterTerm.DataStructurePractice.ex4;

import java.io.*;

public class QuickSort {
    private final int n = 50000;
    private int[] a = new int[n];

    public QuickSort(String filename) {
        // ここを作る
        // ファイル名を引数とする
        // ファイルを開いて全て読み込んで配列aに入れる
        try {
            InputStream data = new FileInputStream(filename);
            InputStreamReader tmp = new InputStreamReader(data);
            BufferedReader reader = new BufferedReader(tmp);
            String input;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private int partition(int l, int r) {
        // ここを作る
        // クイックソートにおける分割を行う
        if ((r - l) % 2 != 0) {
            return (r - l) / 2 + 1;
        } else {
            return (r - l) / 2;
        }
    }

    private void quicksort(int l, int r) {
        // ここを作る
        // クイックソートを実装する
        // 配列aの中身をソートする
        for (int i = 0; i < (r - l); i++) {
            if (a[i] < a[partition(l, r)]) {

            } else if (a[i]>a[partition(l,r)]) {
            }
        }
        quicksort(l, partition(l, r) - 1); // 左の部分をソート        (3)
        quicksort(partition(l, r) + 1, r); // 右の部分をソート        (4)
    }

    public void sort() {
        quicksort(0, a.length - 1);
    }

    public void output(String filename) {
        // ここを作る
        // ファイル名を引数とする
        // 配列arrayをファイルに出力する
        // 1行に1レコード
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            for (int i = 0; i < n; i++) {
                writer.println(String.valueOf(a[i]));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String file1 = "sorted2.txt";
        String file2 = "result_ex4-1_sorted2.txt";

        QuickSort qs = new QuickSort(file1);
        qs.sort();
        qs.output(file2);
    }
}
