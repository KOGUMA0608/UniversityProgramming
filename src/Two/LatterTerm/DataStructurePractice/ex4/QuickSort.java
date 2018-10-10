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
        //前半の部分のピボットの位置(i)
        /*
        int p = a[r];
        int left = l;
        int right = r;
        int pivot;
        while (left > right) {
            while (a[left] < p || (left < right)) {
                left = left + 1;
            }
            while (a[right] > p || (left < right)) {
                right = right - 1;
            }
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }
        int tmp2 = a[left];
        pivot = left;
        a[left] = a[r];
        a[r] = tmp2;
        return pivot;
        */
        return (r - l) / 2 + l;
    }

    private void quicksort(int[] a, int l, int r) {
        // ここを作る
        // クイックソートを実装する
        // 配列aの中身をソートする
        if (l >= r) {
            return;
        }
        int fronthalf = a.length / 2;
        int rearhalf = a.length / 2;
        if (a.length % 2 == 1) {
            fronthalf =a.length / 2 +1;
        }
        int[] frontline = new int[a.length];
        int frontindex = 0;
        int[] rearline = new int[a.length];
        int rearindex = 0;

        int[] marge = new int[frontline.length + rearline.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= a[r]) {
                frontline[frontindex] = a[i];
                frontindex++;
            } else {
                rearline[rearindex] = a[i];
                rearindex++;
            }
        }
        for (int j = 0; j<frontindex; j++) {
            a[j] = frontline[j];
        }
        for (int k = 0; k < rearindex; k++) {
            a[k + frontindex] = rearline[k];
        }
        quicksort(a, l, partition(l, r) - 1);//前半
        quicksort(a, partition(l, r) + 1, r);//後半
    }

    public void sort() {
        quicksort(a, 0, a.length - 1);
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
        String file1 = "rand2.txt";
        String file2 = "result_ex4-1_sorted2.txt";

        QuickSort qs = new QuickSort(file1);
        qs.sort();
        qs.output(file2);
    }


}
/*
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
        //前半の部分のピボットの位置(i)
        int pivot;
        return pivot;
    }

    private void quicksort(int l, int r) {
        // ここを作る
        // クイックソートを実装する
        // 配列aの中身をソートする
            int p = a[r];
            int left = l;
            int right = r;
        if(left>=right){
            return;
        }
            while (left < right) {
                for (; a[left] > p || (left < right); left++) {
                    left = left++;
                }
                for (; a[right] < p || (left < right); right--) {
                    right = right--;
                }
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
            }
            int tmp2 = a[left];
            a[left] = a[r];
            a[r] = tmp2;

            quicksort(0,partition());//前半
            quicksort(partition(),a.length-1);//後半
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
        String file1 = "reverse2.txt";
        String file2 = "result_ex4-1_sorted2.txt";

        QuickSort qs = new QuickSort(file1);
        qs.sort();
        qs.output(file2);
    }


}
 */