package Two.LatterTerm.DataStructurePractice.ex4;

import java.io.*;

public class MergeSort {

    private final int n = 50000;
    private int[] a = new int[n];

    public MergeSort(String filename) {
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

    private void mergesort(int[] a) {
        // ここを作る
        // マージソートを実装する
        // 配列aの中身をソートする
        int[] frontline = new int[a.length / 2];
        int[] rearline = new int[a.length / 2];

        if (a.length <= 1) {
            return;
        }
        for (int i = 0; i < a.length / 2; i++) {
            frontline[i] = a[i];
        }
        for (int j = 0; j < a.length / 2; j++) {
            rearline[j] = a[j + a.length / 2];
        }
        mergesort(frontline);
        mergesort(rearline);


        //int[] merge = new int[a.length];
        for (int i = 0; i < a.length-1; ) {//???
            int frontindex = 0;
            int rearindex = 0;
            while (frontindex < frontline.length && rearindex < rearline.length) {
                if (frontline[frontindex] <= rearline[rearindex]) {
                    a[i] = frontline[frontindex];
                    frontindex++;
                    i++;
                } else {
                    a[i] = rearline[rearindex];
                    rearindex++;
                    i++;
                }
            }
            for (; frontindex < frontline.length;frontindex++ ) {
                a[i] = frontline[frontindex];
                i++;
            }
            for (; rearindex < rearline.length;rearindex++ ) {
                a[i] = rearline[rearindex];
                i++;
            }
            /*
            if (frontindex < frontline.length) {
                a[i] = frontline[frontindex];
                frontindex++;
                i++;
            }
            if (rearindex < rearline.length) {
                a[i] = rearline[rearindex];
                rearindex++;
                i++;
            }
            */
        }
        //列aを2つの列x, yに分割する

        //mergesortを再帰呼び出しで，列xをソートする // (3)
        //mergesortを再帰呼び出しで，列yをソートする // (4)
        //列x, yをマージして，列aにする              // (5)
    }

    public void sort() {
        mergesort(a);
    }

    public void output(String filename) {
        // ここを作る
        // ファイル名を引数とする
        // 配列aをファイルに出力する
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
        String file1 = "rand2.txt";
        String file2 = "result_ex4-2_rand2.txt";

        MergeSort ms = new MergeSort(file1);
        ms.sort();
        ms.output(file2);
    }
}
