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
        int fronthalf = a.length / 2;
        int rearhalf = a.length / 2;
        if (a.length % 2 != 0) {
            fronthalf = a.length / 2 + 1;
            rearhalf = a.length / 2;
        }
        if (a.length <= 1) {
            return;
        }
        int[] frontline = new int[fronthalf];
        int[] rearline = new int[rearhalf];

        for (int i = 0; i < fronthalf; i++) {
            frontline[i] = a[i];
        }
        for (int j = 0; j < rearhalf; j++) {
            rearline[j] = a[j + fronthalf];
        }
        mergesort(frontline);
        mergesort(rearline);

        int[] merge = new int[fronthalf + rearhalf];
        for (int i = 0; i < merge.length; ) {
            int frontindex = 0;
            int rearindex = 0;
            while (frontindex < frontline.length && rearindex < rearline.length) {
                if (frontline[frontindex] <= rearline[rearindex]) {
                    merge[i] = frontline[frontindex];
                    frontindex++;
                    i++;
                } else {
                    merge[i] = rearline[rearindex];
                    rearindex++;
                    i++;
                }
            }
            for (; frontindex < frontline.length; frontindex++) {
                merge[i] = frontline[frontindex];
                i++;
            }
            for (; rearindex < rearline.length; rearindex++) {
                merge[i] = rearline[rearindex];
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
        for (int i = 0; i < merge.length; i++) {
            a[i] = merge[i];
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
