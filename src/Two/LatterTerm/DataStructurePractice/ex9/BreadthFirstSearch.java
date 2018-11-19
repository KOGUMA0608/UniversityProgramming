package Two.LatterTerm.DataStructurePractice.ex9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private class Node {
        int label;
        ArrayList<Node> children = new ArrayList<Node>();
        boolean isVisited;

        public Node(int label) {
            this.label = label;
            this.isVisited = false;
        }

        public void addChild(Node child) {
            children.add(child);
        }
        Node ChildisVisited() {
            for (int i = 0; i < children.size(); i++) {
                Node output = children.get(i);
                if (!output.isVisited) {
                    return output;
                }
            }
            return null;
        }
        public String toString(){
            return String.valueOf(label);
        }
    }

    Node root;
    Queue<Node> queue = new LinkedList<Node>();

    public BreadthFirstSearch() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.addChild(node2);
        node1.addChild(node3);
        node1.addChild(node4);
        node2.addChild(node5);
        node3.addChild(node6);
        node3.addChild(node7);

        root = node1;
    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();

        Node node = bfs.root;
        node.isVisited = true;
        bfs.queue.offer(node);
        System.out.println(node.label);

        while (!bfs.queue.isEmpty()) {
            // ここを作る
            // 幅優先探索になるようにノードを巡る
            // queueをうまく活用すること

            Node seek = bfs.queue.peek();
            Node output = seek.ChildisVisited();
            if (output == null) {
                bfs.queue.poll();
                System.out.println("この下は存在しない!");
                continue;
            }
            output.isVisited = true;
            bfs.queue.add(output);
            System.out.println(output);
        }
    }
}
