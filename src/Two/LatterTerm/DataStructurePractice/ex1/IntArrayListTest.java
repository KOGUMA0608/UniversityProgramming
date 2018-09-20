package Two.LatterTerm.DataStructurePractice.ex1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IntArrayListTest {
    public static void main(String[] args) {
        int sum = 0;
        double ave;
        Scanner scanner = new Scanner(System.in);
        // 整数を要素とするArrayListの宣言と生成
        ArrayList<Integer> intList = new ArrayList<Integer>();
        try {
            System.out.println("整数値を入力してください。整数以外を入力するまで繰り返します。");
            // 入力部分
            // ここを作る
            while (true) {
                int n = scanner.nextInt();
                intList.add(n);
            }
        } catch (InputMismatchException e) {
            System.out.println("入力が完了しました。データの数は" + intList.size());
        }
        for (int i = 0; i < intList.size(); i++) {
            sum += intList.get(i);
        }
        ave = (double) sum / intList.size();
        System.out.println("入力された値は");
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i) + "\t");
        }
        System.out.println("合計は" + sum);
        System.out.println("平均は" + ave);
        scanner.close();
    }
}
