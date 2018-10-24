package Two.LatterTerm.DataStructurePractice.ex6;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        StringBuilder plus = new StringBuilder();
        String input = null;
        Scanner scanner;
        try {
            InputStream data = new FileInputStream("english.txt");
            InputStreamReader tmp = new InputStreamReader(data);
            BufferedReader reader = new BufferedReader(tmp);
            while (reader.ready()) {
                plus.append(reader.readLine());//reader.readLine()
            }
            input = new String(plus);
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        assert input != null;
        scanner = new Scanner(input);
        //scanner.useDelimiter("¥n|¥s|\n");
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.replace(word, map.get(word) + 1);
            }
            //System.out.println(scanner.next());
        }
        for (String key : map.keySet()) {
            System.out.println(key + "=>" + map.get(key));
        }
    }
}
