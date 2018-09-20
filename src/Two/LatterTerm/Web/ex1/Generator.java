package Two.LatterTerm.Web.ex1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Generator {
    public static void main(String[] args) {
        String filename = "src/ex1/Data.csv";
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            for (int i = 0; i < 20; i++) {
                int x = i * i;
                writer.println(i+","+x);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
