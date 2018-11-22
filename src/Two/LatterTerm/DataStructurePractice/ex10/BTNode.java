package Two.LatterTerm.DataStructurePractice.ex10;

public class BTNode {
    private String label;
    private BTNode left;
    private BTNode right;

    public BTNode(String label, BTNode left, BTNode right) {
        this.label = label;
        this.left = left;
        this.right = right;
    }

    public void printNode() {
        printNode("");
    }

    public void printNode(String prefix) {
        // ここを作る
        //System.out.println(label);
        if (right != null) {
            //右はある!
            //System.out.println(this.right.label);
            right.printNode(prefix + "      ");
        }
        System.out.println(prefix + this);
        if (left != null) {
            //左はある!
            // System.out.println(this.left.label);
            left.printNode(prefix + "      ");
        }
    }

    public BTNode search(String name) {
        // ここを作る
        BTNode currentRight;
        BTNode currentLeft;
        System.out.println(this);
        if (this.label.equals(name)) {
            return this;
        }
        if (this.right != null) {
            //右はある!
            currentRight = right.search(name);
            if (currentRight != null) {
                return currentRight;
            }

        }
        if (this.left != null) {
            //左はある!
            currentLeft = left.search(name);
            if (currentLeft != null) {
                return currentLeft;
            }
        }
        return null;
    }

    public String toString() {
        return "[" + label + "]";
    }

    public static void main(String[] args) {
        BTNode tree =
                new BTNode("A",
                        new BTNode("B",
                                new BTNode("C", null, null),
                                new BTNode("E", null, null)
                        ),
                        new BTNode("D", new BTNode("F", null, null),
                                new BTNode("G", null, null))
                );
        tree.printNode();
        System.out.println("Aを探す");
        System.out.println("あった? " + tree.search("A"));
        System.out.println("Bを探す");
        System.out.println("あった? " + tree.search("B"));
        System.out.println("Cを探す");
        System.out.println("あった? " + tree.search("C"));
        System.out.println("Dを探す");
        System.out.println("あった? " + tree.search("D"));
        System.out.println("Eを探す");
        System.out.println("あった? " + tree.search("E"));
        System.out.println("Fを探す");
        System.out.println("あった? " + tree.search("F"));
        System.out.println("Gを探す");
        System.out.println("あった? " + tree.search("G"));
        System.out.println("Zを探す");
        System.out.println("あった? " + tree.search("Z"));
    }
}
/*
 public BTNode search(String name) {
        // ここを作る

        System.out.println(label);
        if (label.equals(name)) {
            return this;
        }
        if (right != null && left != null) {
            //両方ある!
            if (right.label.equals(name)) {
                return right;
            }
            right.search(name);

            if (left.label.equals(name)) {
                return left;
            }
            left.search(name);

        } else if (right != null) {
            //右はある!
            if (right.label.equals(name)) {
                return right;
            }
            right.search(name);

        } else if (left != null) {
            //左はある!
            if (left.label.equals(name)) {
                return left;
            }
            left.search(name);

        } else if (right == null && left == null) {
            //ここで行き止まり!
            if (label.equals(name)) {
                return this;
            }
        }
        return null;
    }
 */
/*
public BTNode search(String name) {
        // ここを作る
        System.out.println(label);
        if (right != null && left != null) {
            //両方ある!
            if (right.label.equals(name)) {
                return right;
            }
            right.search(name);

            if (left.label.equals(name)) {
                return left;
            }
            left.search(name);

        } else if (right != null) {
            //右はある!
            if (right.label.equals(name)) {
                return right;
            }
            right.search(name);

        } else if (left != null) {
            //左はある!
            if (left.label.equals(name)) {
                return left;
            }
            left.search(name);
        }

        return null;
    }
 */
/*
//これだとなぜ動かない？
public BTNode search(String name) {
        // ここを作る
        BTNode currentRight;
        BTNode currentLeft;
        System.out.println(this);
        if (this.label.equals(name)) {
            return this;
        }
        if (this.right != null && this.left != null) {
            //両方ある!
            currentRight = right.search(name);
            currentLeft = left.search(name);
            if (currentRight != null) {
                return currentRight;
            } else if (currentLeft != null) {
                return currentLeft;
            }
        } else if (this.right != null) {
            //右はある!
            currentRight = right.search(name);
            if (currentRight != null) {
                return currentRight;
            }

        } else if (this.left != null) {
            //左はある!
            currentLeft = left.search(name);
            if (currentLeft != null) {
                return currentLeft;
            }
        }
        return null;
    }
 */