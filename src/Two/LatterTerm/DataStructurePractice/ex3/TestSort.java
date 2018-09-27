package Two.LatterTerm.DataStructurePractice.ex3;

public class TestSort {
    public static void main(String[] args) {
        long start, stop;
        String file1 = "rand2.txt";
        String file2 = "sorted2.txt";
        String file3 = "reverse2.txt";
        String file4 = "same2.txt";
        // ここを作る
        // 各ファイルに対して，各ソートアルゴリズムを実行する
        // 各アルゴリズムでソートする際に，その処理時間を測定する
        long time[] = new long[12];
        BubbleSort bubbleSort[] = new BubbleSort[4];
        bubbleSort[0] = new BubbleSort(file1);
        bubbleSort[1] = new BubbleSort(file2);
        bubbleSort[2] = new BubbleSort(file3);
        bubbleSort[3] = new BubbleSort(file4);

        InsertionSort insertionSort[] = new InsertionSort[4];
        insertionSort[0] = new InsertionSort(file1);
        insertionSort[1] = new InsertionSort(file2);
        insertionSort[2] = new InsertionSort(file3);
        insertionSort[3] = new InsertionSort(file4);

        SelectionSort selectionSort[] = new SelectionSort[4];
        selectionSort[0] = new SelectionSort(file1);
        selectionSort[1] = new SelectionSort(file2);
        selectionSort[2] = new SelectionSort(file3);
        selectionSort[3] = new SelectionSort(file4);
        int k = 0;
        for (int j = 0; j < 4; j++, k++) {
            start = System.nanoTime();
            bubbleSort[j].sort();
            stop = System.nanoTime();
            time[k] = (stop - start) / 1000000;
        }
        for (int j = 0; j < 4; j++, k++) {
            start = System.nanoTime();
            insertionSort[j].sort();
            stop = System.nanoTime();
            time[k] = (stop - start) / 1000000;
        }
        for (int j = 0; j < 4; j++, k++) {
            start = System.nanoTime();
            selectionSort[j].sort();
            stop = System.nanoTime();
            time[k] = (stop - start) / 1000000;
        }
        System.out.println("rand2.txtのソート");
        System.out.println("バブルソート:" + time[0] + "[ms]");
        System.out.println("選択ソート:" + time[4] + "[ms]");
        System.out.println("挿入ソート:" + time[8] + "[ms]");
        System.out.println("reverse2.txtのソート");
        System.out.println("バブルソート:" + time[1] + "[ms]");
        System.out.println("選択ソート:" + time[5] + "[ms]");
        System.out.println("挿入ソート:" + time[9] + "[ms]");
        System.out.println("sorted2.txtのソート");
        System.out.println("バブルソート:" + time[2] + "[ms]");
        System.out.println("選択ソート:" + time[6] + "[ms]");
        System.out.println("挿入ソート:" + time[10] + "[ms]");
        System.out.println("same2.txtのソート");
        System.out.println("バブルソート:" + time[3] + "[ms]");
        System.out.println("選択ソート:" + time[7] + "[ms]");
        System.out.println("挿入ソート:" + time[11] + "[ms]");
    }
}