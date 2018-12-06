package Two.LatterTerm.DataStructurePractice.ex12;

public class HashOpenAddressing {
    private static class MyKey {
        String key;
        String data;

        public MyKey(String key, String data) {
            this.key = key;
            this.data = data;
        }
    }

    private MyKey[] table;
    private int bucketSize;
    private int n;

    private static final String REMOVED = "REMOVED";
    private static final String EMPTY = "EMPTY";
    private static final int BUCKET_SIZE = 23;

    public HashOpenAddressing() {
        this(BUCKET_SIZE);
    }

    public HashOpenAddressing(int bucketSize) {
        // ここを作る
        this.bucketSize = bucketSize;
    }

    public int hash(String key) {
        // ここを作る
        int sum = 0;

        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum % bucketSize;
    }

    public int rehash(int hash) {
        // ここを作る
        return (hash + 1) % bucketSize;
    }

    public String search(String key) {
        // ここを作る
        for (MyKey myKey : table) {
            if (myKey.key.equals(key)) {
                return myKey.data;
            }
        }
        return null;
    }

    public boolean add(String key, String data) {
        // ここを作る
        if (table == null) {
            //System.out.println("ここにはない!");
            table = new MyKey[bucketSize];
            for (int i = 0; i < table.length; i++) {
                table[i] = new MyKey("EMPTY", "");
            }
        }

        if (table[hash(key)].key.equals(EMPTY) || table[hash(key)].key.equals(REMOVED)) {
            table[hash(key)] = new MyKey(key, data);
            n++;
        } else {
            int hash = hash(key);
            while (true) {
                hash = rehash(hash);
                if (table[hash].key.equals(EMPTY) || table[hash(key)].key.equals(REMOVED)) {
                    table[hash] = new MyKey(key, data);
                    n++;
                    return true;
                } else if (hash == hash(key)) {
                    return false;
                }
            }
        }

        return false;
    }

    public boolean remove(String key) {
        // ここを作る
        int keyHash = hash(key);
        if (!table[keyHash].key.equals(EMPTY)) {
            table[keyHash].key = REMOVED;
            n--;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        // ここを作る
        int i = 0;
        for (MyKey myKey : table) {
            if (myKey.key.equals(EMPTY)) {
                System.out.println("bucket" + i + ":EMPTY");
            } else if (myKey.key.equals(REMOVED)) {
                System.out.println("bucket" + i + ":REMOVED");
            } else {
                System.out.println("bucket" + i + ":key=[" + myKey.key + "] data=[" + myKey.data + "]");
            }
            i++;
        }
        return "要素数:" + n;
    }

    public static void main(String[] args) {
        HashOpenAddressing bucket = new HashOpenAddressing(11);

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

        System.out.print("key:twoを探索: ");
        System.out.println(bucket.search("two"));
        System.out.println();

        System.out.print("key:fiveを探索: ");
        System.out.println(bucket.search("five"));
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
