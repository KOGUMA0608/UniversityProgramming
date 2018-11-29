package Two.LatterTerm.DataStructurePractice.ex11;

public class MyLinkedList {
    private Element head; // 先頭
    private Element tail; // 末尾

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public int size() {
        // リストの要素数を数えて返す
        Element element = head;
        for (int i = 0; ; ) {
            try {
                element = element.getNext();
                //System.out.println("追加");
                i++;
                if (element != null) {
                    //ここだと反応しない？
                    //i++;
                } else {
                    return i;
                }
            } catch (NullPointerException e) {
                System.out.println(e);
                return i;
            }
        }
    }

    public void addFirst(String str) {
        // 先頭に要素を追加
        // リストが空なら要素を作って先頭と末尾に
        if (head == null) {
            head = new Element(str);
            tail = head;
            return;
        }
        // リストが空でないなら先頭に追加
        else {
            Element element = head;
            head = new Element(str);
            head.setNext(element);
            head.getNext().setPrevious(head);
        }
    }

    public void addLast(String str) {
        // 末尾に要素を追加
        // リストが空なら要素を作って先頭と末尾に
        if (head == null) {
            head = new Element(str);
            tail = head;
            return;
        }
        // リストが空でないなら末尾に追加
        Element element = tail;
        tail = new Element(str);
        tail.setPrevious(element);
        tail.getPrevious().setNext(tail);

    }

    public void add(int index, String str) {
        // index番目に要素を挿入
        // indexの範囲チェック
        if (index < 0 || index > size()) {
            System.out.println("インデックスが範囲外です．");
            return;
        }
        // indexがゼロなら先頭に追加
        else if (index == 0) {
            addFirst(str);
            // indexがサイズと同じなら末尾に追加
        } else if (index == size()) {
            addLast(str);
        }
        // それ以外，ただし，i番目を見つけて，その前に追加
        else {
            Element previousElement = head;
            Element insert = new Element(str);
            Element nextElement;
            for (int i = 1; i < index; i++) {
                previousElement = previousElement.getNext();
            }
            nextElement = previousElement.getNext();
            previousElement.setNext(insert);
            previousElement.getNext().setPrevious(previousElement);
            nextElement.setPrevious(insert);
            nextElement.getPrevious().setNext(nextElement);
        }
    }

    public String removeFirst() {
        // 先頭の要素を削除
        // 要素があるかチェック
        if (head == null) {
            System.out.println("削除する要素がありません．");
            return null;
        }
        // 要素が1つだけなら
        if (head.getNext() == null) {
            Element target = head;
            head = null;
            tail = null;
            return target.getData();
        }
        // それ以外(要素が2つ以上)
        //head.getNext()=head;

        //System.out.println("削除するのは"+head);
        /*
        Element nextHead = head.getNext();
        head = null;
        head = nextHead;
        */
        Element nextHead = head.getNext();
        head = null;
        nextHead.setPrevious(null);
        head = nextHead;
        //System.out.println("削除するのは"+tail);
        return null;
    }

    public String removeLast() {
        // 末尾の要素を削除
        // 要素があるかチェック
        if (head == null) {
            System.out.println("削除する要素がありません．");
            return null;
        }
        // 要素が1つだけなら
        if (head.getNext() == null) {
            Element target = head;
            head = null;
            tail = null;
            return target.getData();
        }
        // それ以外(要素が2つ以上)
        Element nextTail = tail.getPrevious();
        tail = null;
        nextTail.setNext(null);
        tail = nextTail;
        //System.out.println("削除するのは"+tail);
        return null;
    }

    public String remove(int index) {
        // index番目の要素を削除
        // indexの範囲チェック
        if (index < 0 || index >= size()) {
            System.out.println("インデックスが範囲外です．");
            return null;
        }
        // indexがゼロなら先頭を削除
        if (index == 0) {
            return removeFirst();
        }
        // indexがサイズ-1なら末尾を削除
        if (index == size() - 1) {
            return removeLast();
        }
        // それ以外
        else {
            Element previousElement = head;
            Element eraseElement;
            Element nextElement;
            for (int i = 1; i < index; i++) {
                previousElement = previousElement.getNext();
            }
            eraseElement = previousElement.getNext();
            nextElement = eraseElement.getNext();
            previousElement.setNext(nextElement);
            previousElement.getNext().setPrevious(previousElement);
            nextElement.setPrevious(previousElement);
            nextElement.getPrevious().setNext(nextElement);

        }

        return null;
    }

    public boolean contains(String str) {
        // 要素が含まれているかどうか返す
        // 要素がないならfalse
        if (head == null) {
            return false;
        }
        Element element = head;
        while (element != tail) {
            if (element.getData().equals(str)) {
                return true;
            }
            element = element.getNext();
        }
        return element.getData().equals(str);
        /*
        for (Element element : this.head) {
            System.out.println("調査");
            // 要素をたどってあるかないか探す
            if (element.getData().equals(str)) {
                return true;
            }
        }
        return false;
         */
    }

    public void print() {
        // 要素を先頭から表示
        System.out.print("リスト順: ");
        if (head == null) {
            System.out.println("null");
            return;
        }
        Element p = head;
        while (p != null) {
            System.out.print(p + " -> ");
            p = p.getNext();
        }
        System.out.println("null");
    }

    public void printReverse() {
        // 要素を末尾から表示
        System.out.print("リスト逆: ");
        if (tail == null) {
            System.out.println("null");
            return;
        }
        Element p = tail;
        while (p != null) {
            System.out.print(p + " -> ");
            p = p.getPrevious();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // いろいろと試す
        System.out.println("リストの生成");
        MyLinkedList list = new MyLinkedList();
        list.print();
        System.out.println("サイズ: " + list.size());
        System.out.println("dを先頭に追加");
        list.addFirst("d");
        list.print();
        System.out.println("サイズ: " + list.size());
        System.out.println("cを先頭に追加");
        list.addFirst("c");
        list.print();
        System.out.println("eを最後に追加");
        list.addLast("e");
        list.print();
        list.printReverse();
        System.out.println("bを先頭に追加");
        list.addFirst("b");
        list.print();
        System.out.println("fを最後に追加");
        list.addLast("f");
        list.print();
        list.printReverse();
        System.out.println("fが含まれているか?: " + list.contains("f"));
        System.out.println("bが含まれているか?: " + list.contains("b"));
        System.out.println("dが含まれているか?: " + list.contains("d"));
        System.out.println("zが含まれているか?: " + list.contains("z"));
        list.print();
        System.out.println("先頭を削除");
        list.removeFirst();
        list.print();
        System.out.println("最後を削除");
        list.removeLast();
        list.print();
        System.out.println("先頭を削除");
        list.removeFirst();
        list.print();
        System.out.println("最後を削除");
        list.removeLast();
        list.print();
        System.out.println("先頭を削除");
        list.removeFirst();
        list.print();
        System.out.println("0番目にdを追加");
        list.add(0, "d");
        list.print();
        System.out.println("0番目にbを追加");
        list.add(0, "b");
        list.print();
        System.out.println("2番目にfを追加");
        list.add(2, "f");
        list.print();
        System.out.println("1番目にcを追加");
        list.add(1, "c");
        list.print();
        System.out.println("3番目にeを追加");
        list.add(3, "e");
        list.print();
        System.out.println("5番目にgを追加");
        list.add(5, "g");
        list.print();
        list.printReverse();
        System.out.println("0番目を削除");
        list.remove(0);
        list.print();
        System.out.println("4番目を削除");
        list.remove(4);
        list.print();
        System.out.println("1番目を削除");
        list.remove(1);
        list.print();
        System.out.println("2番目を削除");
        list.remove(2);
        list.print();
        list.printReverse();
        System.out.println("1番目を削除");
        list.remove(1);
        list.print();
        System.out.println("0番目を削除");
        list.remove(0);
        list.print();
        System.out.println("end.");
    }
}
