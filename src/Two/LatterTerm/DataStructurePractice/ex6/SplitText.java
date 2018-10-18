package Two.LatterTerm.DataStructurePractice.ex6;

import java.io.*;
import java.util.Scanner;

public class SplitText {
    public static void main(String[] args) {


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
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
