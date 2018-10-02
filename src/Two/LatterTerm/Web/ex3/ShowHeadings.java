package Two.LatterTerm.Web.ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ShowHeadings {

    public static void main(String[] args) {
        ArrayList input = new ArrayList();
        if (args.length != 1) {
            System.out.println("使用法：java ShowFile1 ファイル");
            System.out.println("例：java ShowFile1 ShowFile1.java");
            System.exit(0);
        }
        //String filename = args[0];
        try {
            // URLオブジェクトを生成
            URL url = new URL(args[0]);
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
            //} catch (FileNotFoundException e) {
            //    System.out.println(filename + "が見つかりません。");
        } catch (IOException e) {
            System.out.println(e);
        }

        for (int i = 0; i < input.size(); i++) {
            //System.out.println(input.get(i));
            String str;
            str = (String) input.get(i);
            if (str.contains("<h1>") || str.contains("<h2>") || str.contains("<h3>") || str.contains("<h4>") || str.contains("<h5>") || str.contains("<h6>")) {
                str = str.substring(str.indexOf("<"));
                System.out.println(str);
            }
        }
    }
}

