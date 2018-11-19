package Two.LatterTerm.DataStructurePractice.ex9;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch {
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
    }

    Node root;
    Deque<Node> stack = new LinkedList<Node>();

    public DepthFirstSearch() {
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
        DepthFirstSearch dfs = new DepthFirstSearch();

        Node node = dfs.root;
        node.isVisited = true;
        dfs.stack.push(node);
        System.out.println(node.label);
        boolean isFlag = false;

        while (!dfs.stack.isEmpty()) {
            // ここを作る
            // 深さ優先探索になるようにノードを巡る
            // stackをうまく活用すること
            //Node seek = node;


            int point = 0;
            if (!isFlag) {
                try {
                    node = node.children.get(point);
                    point = 0;
                    node.isVisited = true;
                    dfs.stack.push(node);
                    System.out.println(node.label);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("底まで到達した!");
                    isFlag = true;

                }
            } else {
                node = dfs.stack.pop();
                try {
                    if (point < node.children.size()) {
                        point++;
                    }
                    if (node.children.get(point) != null) {
                        isFlag = false;
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("このノードにはこれ以上探索できる場所がない、現在の位置は" + node.label);
                }
            }
        }
    }
}
/*
for (int i = 0; i < node.children.size(); i++) {

                node = node.children.get(0);
                node.isVisited = true;
                dfs.stack.push(node);
                System.out.println(node.label);
            }
 */