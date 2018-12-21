package Two.LatterTerm.DataStructurePractice.ex13;

public class BinarySearchTree {

    private class BTNode {
        Integer data;
        BTNode left;
        BTNode right;

        public BTNode(Integer data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void printNode() {
            printNode("");
        }

        public void printNode(String prefix) {
            if (right != null) {
                right.printNode(prefix + "\t");
            }
            System.out.println(prefix + this.data);
            if (left != null) {
                left.printNode(prefix + "\t");
            }
        }
    }

    private BTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BTNode search(Integer key) {
        // keyで示されるノードを探索する
        // keyが見つかればそのノードを返し，
        // 見つからなければnullを返す
        return null;
    }

    public BTNode add(Integer key) {
        // keyを二分探索木に追加する
        // ここを作成する
        // どこに追加するか
        // 左部分木に追加するか
        // 右部分木に追加するか
        if (root == null) {
            root = new BTNode(key);
        } else {
            BTNode comp = root;
            for (; ; ) {
                if (key < comp.data) {
                    //keyは比較対象より小さい→左へ
                    //まだ下があるか？
                    if (comp.left == null) {
                        comp.left = new BTNode(key);
                        return null;
                    } else {
                        comp = comp.left;
                    }
                } else if (key > comp.data) {
                    //keyが比較対象より大きいなら右へ
                    //まだ下があるか？
                    if (comp.right == null) {
                        comp.right = new BTNode(key);
                        return null;
                    } else {
                        comp = comp.right;
                    }
                }
            }
        }
        return null;
    }

    public boolean remove(Integer key) {
        // keyを二分探索木から探し，あれば削除する
        // ここを作成する
        // 1. 子を持たない場合
        // 2. 子を1つだけ持つ場合
        // 3. 左右の子を持つ場合（右部分木で最小のノードで置き換える）
        BTNode comp = root;
        while (true) {
            //両方ない場合
            if (comp.left == null && comp.right == null) {
                return false;
            }
            //左しか無い
            if (comp.right == null) {
                if (comp.left.data.equals(key)) {
                    if (comp.left.left == null && comp.left.right == null) {
                        comp.left = null;
                        break;
                    }
                    if (comp.left.right == null) {
                        comp.left = comp.left.left;
                        break;
                    }
                    if (comp.left.left == null) {
                        comp.left = comp.left.right;
                        break;
                    }
                    comp.left = removeMin(comp, comp.left);
                }
                comp = comp.left;
                continue;
            }
            //右しか無い
            if (comp.left == null) {
                if (comp.right.data.equals(key)) {
                    if (comp.right.left == null && comp.right.right == null) {
                        comp.right = null;
                        break;
                    }
                    if (comp.right.right == null) {
                        comp.right = comp.right.left;
                        break;
                    }
                    if (comp.right.left == null) {
                        comp.right = comp.right.right;
                        break;
                    }
                    comp.right = removeMin(comp, comp.right);
                }
                comp = comp.right;
                continue;
            }
            //両方ある場合
            if (comp.data > key) {
                //左を見る
                if (comp.right == null) {
                    if (comp.left.data.equals(key)) {
                        if (comp.left.left == null && comp.left.right == null) {
                            comp.left = null;
                            break;
                        }
                        if (comp.left.right == null) {
                            comp.left = comp.left.left;
                            break;
                        }
                        if (comp.left.left == null) {
                            comp.left = comp.left.right;
                            break;
                        }
                        comp.left = removeMin(comp, comp.left);
                    }


                }
                comp = comp.left;
                continue;
            }
            //右を見る
            if (comp.left == null) {
                if (comp.right.data.equals(key)) {
                    if (comp.right.left == null && comp.right.right == null) {
                        comp.right = null;
                        break;
                    }
                    if (comp.right.right == null) {
                        comp.right = comp.right.left;
                        break;
                    }
                    if (comp.right.left == null) {
                        comp.right = comp.right.right;
                        break;
                    }
                    comp.right = removeMin(comp, comp.right);
                }
            }
            comp = comp.right;
            continue;
        }

        /*
        if (root == null) {
            return false;
        } else {
            BTNode comp = root;

            for (; ; ) {
                if (comp.right == null && comp.left == null) {
                    //子無しだったら
                    comp=null;
                    return true;
                } else if (comp.right != null && comp.left != null) {
                    //両方あり
                    removeMin();
                    return true;
                } else {
                    //片方のみ

                }
            }
        }


         BTNode comp = root;
        BTNode leftNode = comp.left;
        BTNode rightNode = comp.right;
        if (leftNode.data.equals(key)) {
            if (leftNode.left == null && leftNode.right == null) {
                comp.left = null;
            }else if(leftNode.left!=null&&leftNode.right!=null){
                //removeMin();
            }else {
            }
        }
         */
        return false;
    }

    private BTNode removeMin(BTNode parent, BTNode p) {
        // 削除すべきノードが左右の子を持っているときに
        // 最小のノードを探し出すメソッド
        // ここを作成する
        BTNode target = p.right;
        BTNode prevTarget = p;
        while (true) {
            if (target.left == null) {
                //targetの右がない
                if (target.right == null) {
                    prevTarget.left = null;
                    return target;
                }
                //targetの右がある
                prevTarget.left = target.right;
                return target;
            }
            prevTarget = target;
            target = target.left;
        }
    }

    public void printNode() {
        root.printNode("");
    }

    public static void main(String[] args) {
        System.out.println("二分探索木の作成");
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(13);
        bst.add(5);
        bst.add(21);
        bst.add(15);
        bst.add(7);
        bst.add(2);
        bst.add(6);

        bst.printNode();

        BTNode result;
        System.out.print("ノード3を探索:");
        result = bst.search(3);
        if (result != null) {
            System.out.println(result.data);
        } else {
            System.out.println("探索失敗");
        }

        System.out.print("ノード5を探索:");
        result = bst.search(5);
        if (result != null) {
            System.out.println(result.data);
        } else {
            System.out.println("探索失敗");
        }

        System.out.println("ノード8を追加");
        bst.add(8);
        bst.printNode();


        System.out.println("子を1つだけ持ったノードの削除");
        BinarySearchTree bst2 = new BinarySearchTree();

        bst2.add(9);
        bst2.add(14);
        bst2.add(5);
        bst2.add(3);
        bst2.add(4);
        bst2.add(1);
       // bst2.add(14);
        bst2.printNode();

        System.out.println("ノード5を削除");
        if (bst2.remove(5)) {
            System.out.println("削除成功");
        }
        bst2.printNode();


        System.out.println("子を2つ持ったノードの削除");
        BinarySearchTree bst3 = new BinarySearchTree();

        bst3.add(20);
        bst3.add(23);
        bst3.add(29);
        bst3.add(7);
        bst3.add(18);
        bst3.add(4);
        bst3.add(2);
        bst3.add(5);
        bst3.add(10);
        bst3.add(15);
        bst3.printNode();

        System.out.println("ノード7を削除");
        if (bst3.remove(7)) {
            System.out.println("削除成功");
        }
        bst3.printNode();
    }
}
