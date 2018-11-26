package Two.LatterTerm.Web.ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemSearcherUsingLinkedPages {

    public static void main(String[] args) {
        ArrayList input = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("型番を入力してください");
        String search=scanner.nextLine();
        scanner.close();
        try {
            // URLオブジェクトを生成
            URL url = new URL("http://www.tsukumo.co.jp/feeds/specials.xml");
            // URLオブジェクトから、接続にいくURLConnectionオブジェクトを取得
            URLConnection connection = url.openConnection();
            // 接続
            connection.connect();
            // サーバからやってくるデータをInputStreamとして取得
            InputStream inputStream = connection.getInputStream();
            // 次に inputStream を読み込む InputStreamReader のインスタンス inputStreamReader を生成
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            // さらに inputStreamReader をラップする BufferedReader のインスタンス reader を生成
            BufferedReader reader = new BufferedReader(inputStreamReader);
            //BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        for (int i = 0; i < input.size(); i++) {
            Pattern pattern = Pattern.compile("<h1>|<h2>|<h3>|<h4>|<h5>|<h6>");
            Matcher matcher = pattern.matcher((String) input.get(i));
            if (matcher.find()) {
                System.out.println((String) input.get(i));
            }
        }
    }
}
