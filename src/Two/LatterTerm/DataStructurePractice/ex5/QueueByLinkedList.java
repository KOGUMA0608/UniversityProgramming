package Two.LatterTerm.DataStructurePractice.ex5;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByLinkedList {
    public static void main(String args[]) {//Deque<String> list=new ArrayDeque<String>();
        Deque<String> list = new LinkedList<String>();
        list.offer("Alice");
        System.out.println("入力された値は" + list.getLast());//入力された値を表示する(削除はしない)
        System.out.println("キューの内容は" + list);//キューの内容を表示する(削除はしない)

        list.offer("Bob");
        System.out.println("入力された値は" + list.getLast());//入力された値を表示する(削除はしない)
        System.out.println("キューの内容は" + list);//キューの内容を表示する(削除はしない)

        list.offer("Charlie");
        System.out.println("入力された値は" + list.getLast());//入力された値を表示する(削除はしない)
        System.out.println("キューの内容は" + list);//キューの内容を表示する(削除はしない)

        list.offer("Diana");
        System.out.println("入力された値は" + list.getLast());//入力された値を表示する(削除はしない)
        System.out.println("キューの内容は" + list);//キューの内容を表示する(削除はしない)

        list.offer("Elmo");
        System.out.println("入力された値は" + list.getLast());//入力された値を表示する(削除はしない)
        System.out.println("キューの内容は" + list);//キューの内容を表示する(削除はしない)

        list.offer("Fred");
        System.out.println("入力された値は" + list.getLast());//入力された値を表示する(削除はしない)
        System.out.println("キューの内容は" + list);//キューの内容を表示する(削除はしない)


        while (list.peek() != null) {
            System.out.println("取り出された値は" + list.remove());//取り出された値を表示して削除
            System.out.println("キューの内容は" + list);//キューの内容を表示する(削除はしない)
        }
    }

}
