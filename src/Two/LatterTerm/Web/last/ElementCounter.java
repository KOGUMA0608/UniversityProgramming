package Two.LatterTerm.Web.last;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ElementCounter {
    public static void main(String[] args) {

    }

    public void mapping(LinkedHashMap input, ArrayList arrayList) {
        LinkedHashMap<String, Integer> map = input;
        ArrayList<String> list = arrayList;
        //scanner.useDelimiter("¥n|¥s|\n");

        for (String word : list) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.replace(word, map.get(word) + 1);
            }
            //System.out.println(scanner.next());
        }
        /*
        for (String key : map.keySet()) {
            System.out.println(key + "=>" + map.get(key));
        }
        */
    }
}
