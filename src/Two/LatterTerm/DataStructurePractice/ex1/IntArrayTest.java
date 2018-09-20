package Two.LatterTerm.DataStructurePractice.ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntArrayTest {
    public static void main(String[] args) {
        int element = 0;
        int array[] = null;
        int sum = 0;
        double ave = 0;
        // write your code here
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("配列の大きさを入れてください。");
        try {
            int n = scanner.nextInt(); // 個数の入力
            if (n <= 0) {
                System.out.println("ゼロより大きな値を入れてください。");
                System.exit(0);
            }
            // 配列の確保
            // ここを作る
            element = n;
            array = new int[element];

            System.out.println("整数値を" + n + "個入れてください。");
            // 配列に値を入力
            // ここを作る
            for (int i = 0; i < element; i++) {
                try {
                    int j = input.nextInt();
                    array[i] = j;
                } catch (InputMismatchException e) {
                    System.out.println("エラー!");
                    e.printStackTrace();
                    System.exit(0);
                }

            }

        } catch (InputMismatchException e) {
            System.out.println("数値の形式が違います。");
            e.printStackTrace();
            System.exit(0);
        }
        for (int i = 0; i < element; i++) {
            sum += array[i];
        }
        ave = (double) sum / element;

        System.out.println("入力された値は");
        for (int i = 0; i < element; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("合計は" + sum);
        System.out.println("平均は" + ave);

        scanner.close();
        input.close();

    }
}
