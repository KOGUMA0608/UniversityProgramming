package Two.LatterTerm.DataStructurePractice.ex12;

public class HashChain {

    private static class MyKey {
        String key;
        String data;
        MyKey next;

        public MyKey(String key, String data) {
            this.key = key;
            this.data = data;
        }
    }

    private MyKey[] table;
    private int bucketSize;
    private int n;
    private static final int BUCKET_SIZE = 10;

    public HashChain() {
        this(BUCKET_SIZE);
    }

    public HashChain(int bucketSize) {
        // ここを作る

    }

    public int hash(String key) {
        // ここを作る
        int sum = 0;

        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum % BUCKET_SIZE;
    }

    public String search(String key) {
        // ここを作る
        for (MyKey myKey : table) {
            if (myKey != null && myKey.key.equals(key)) {
                return myKey.data;
            }
        }
        return null;
    }

    public boolean add(String key, String data) {
        // ここを作る
        if (table == null) {
            //System.out.println("ここにはない!");
            table = new MyKey[BUCKET_SIZE];
        }

        if (table[hash(key)] == null) {
            table[hash(key)] = new MyKey(key, data);
        } else {
            MyKey temp = table[hash(key)];
            table[hash(key)] = new MyKey(key, data);
            table[hash(key)].next = temp;
        }
        n++;
        return true;
    }

    public boolean remove(String key) {
        // ここを作る
        for (MyKey myKey : table) {
            if (myKey != null && myKey.key.equals(key)) {
                if (myKey.next == null) {
                    myKey = null;
                } else {
                    myKey = myKey.next;
                }
            }
        }
        if (table[hash(key)] != null && table[hash(key)].next != null) {
            table[hash(key)] = table[hash(key)].next;
            n--;
            return true;
        } else if (table[hash(key)] != null && table[hash(key)].next == null) {
            table[hash(key)] = null;
            n--;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String s = "";

        for (int i = 0; i < table.length; i++) {
            s += "bucket" + i + ":";
            for (MyKey p = table[i]; p != null; p = p.next) {
                s += "[" + p.key + ":" + p.data + "] ";
            }
            s += "\n";
        }
        s += "要素数:" + n + "\n";
        return s;
    }

    public static void main(String[] args) {
        HashChain bucket = new HashChain();

        bucket.add("one", "one1");
        bucket.add("two", "two2");
        bucket.add("three", "three3");
        bucket.add("four", "four4");
        bucket.add("five", "five5");
        bucket.add("six", "six6");
        bucket.add("seven", "seven7");

        System.out.println(bucket.toString());

        System.out.print("key:fiveを探索: ");
        System.out.println(bucket.search("five"));
        System.out.println();

        System.out.println("key:threeを削除");
        if (bucket.remove("three")) {
            System.out.println(bucket.toString());
        }

        System.out.print("key:threeを探索: ");
        System.out.println(bucket.search("three"));
        System.out.println();

        bucket.add("eight", "eight8");
        bucket.add("nine", "nine9");
        bucket.add("ten", "ten10");

        System.out.println(bucket.toString());

        System.out.println("key:nineを削除");
        if (bucket.remove("nine")) {
            System.out.println(bucket.toString());
        }
    }
}
/*
for (MyKey myKey : table) {
            if (myKey.key == null || myKey.key.isEmpty()) {
                System.out.println("AAA");
                break;
            }
            else if (myKey.key.equals(key)) {
                return false;
            }
        }
 */