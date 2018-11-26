package Two.LatterTerm.Web.ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ContextExtractor {

    /*
     * テスト用のメインメソッド
     */
    public static void main(String[] args) {
        ContextExtractor extractor = new ContextExtractor();
        String urlString = "https://store.shopping.yahoo.co.jp/bose/ss-free.html";
        String word = "質量";
        String context = extractor.contextSearcher(urlString, word);
        if(context != null) {
            System.out.println(word + "を含む行: " + context);
        }
        else {
            System.out.println(word + "を含む行はありません。");
        }
    }
    /*
     * Webページ内から、指定された単語を含む行を得る
     * @param urlString WebページのURL
     * @param word ページ内から探す単語
     * @return 単語wordが出現する最初の行全体 (単語が現れなければnull)
     */
    public String contextSearcher(String urlString, String word) {
        String context = null;
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.contains(word)) {
                    context = line;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return context;
    }
}
