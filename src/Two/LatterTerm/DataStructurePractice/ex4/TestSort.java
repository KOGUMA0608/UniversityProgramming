package Two.LatterTerm.DataStructurePractice.ex4;

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
        long time[] = new long[20];
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

        QuickSort quickSort[] = new QuickSort[4];
        quickSort[0] = new QuickSort(file1);
        quickSort[1] = new QuickSort(file2);
        quickSort[2] = new QuickSort(file3);
        quickSort[3] = new QuickSort(file4);

        MergeSort mergeSort[] = new MergeSort[4];
        mergeSort[0] = new MergeSort(file1);
        mergeSort[1] = new MergeSort(file2);
        mergeSort[2] = new MergeSort(file3);
        mergeSort[3] = new MergeSort(file4);

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
        for (int j = 0; j < 4; j++, k++) {
            start = System.nanoTime();
            quickSort[j].sort();
            stop = System.nanoTime();
            time[k] = (stop - start) / 1000000;
        }
        for (int j = 0; j < 4; j++, k++) {
            start = System.nanoTime();
            mergeSort[j].sort();
            stop = System.nanoTime();
            time[k] = (stop - start) / 1000000;
        }
        System.out.println("rand2.txtのソート");
        System.out.println("バブルソート:" + time[0] + "[ms]");
        System.out.println("選択ソート:" + time[4] + "[ms]");
        System.out.println("挿入ソート:" + time[8] + "[ms]");
        System.out.println("クイックソート:" + time[12] + "[ms]");
        System.out.println("マージソート:" + time[16] + "[ms]");

        System.out.println("reverse2.txtのソート");
        System.out.println("バブルソート:" + time[1] + "[ms]");
        System.out.println("選択ソート:" + time[5] + "[ms]");
        System.out.println("挿入ソート:" + time[9] + "[ms]");
        System.out.println("クイックソート:" + time[13] + "[ms]");
        System.out.println("マージソート:" + time[17] + "[ms]");

        System.out.println("sorted2.txtのソート");
        System.out.println("バブルソート:" + time[2] + "[ms]");
        System.out.println("選択ソート:" + time[6] + "[ms]");
        System.out.println("挿入ソート:" + time[10] + "[ms]");
        System.out.println("クイックソート:" + time[14] + "[ms]");
        System.out.println("マージソート:" + time[18] + "[ms]");

        System.out.println("same2.txtのソート");
        System.out.println("バブルソート:" + time[3] + "[ms]");
        System.out.println("選択ソート:" + time[7] + "[ms]");
        System.out.println("挿入ソート:" + time[11] + "[ms]");
        System.out.println("クイックソート:" + time[15] + "[ms]");
        System.out.println("マージソート:" + time[19] + "[ms]");

    }
}