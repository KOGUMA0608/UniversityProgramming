package Two.LatterTerm.DataStructurePractice.ex6;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Alice");
        set.add("Bob");
        set.add("Charlie");
        set.add("Diana");
        set.add("Elmo");
        set.add("Fred");
        set.add("Diana");
        set.add("Bob");

        for(String str : set) {
            System.out.println(str);
        }
    }
}
