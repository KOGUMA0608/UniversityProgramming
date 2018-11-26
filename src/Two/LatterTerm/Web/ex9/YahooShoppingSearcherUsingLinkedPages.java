package Two.LatterTerm.Web.ex9;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSParser;

public class YahooShoppingSearcherUsingLinkedPages {
    public static void main(String[] args) {
        YahooShoppingSearcherUsingLinkedPages viewer = new YahooShoppingSearcherUsingLinkedPages();
        // 検索語の入力
        Scanner scanner = new Scanner(System.in);
        System.out.print("検索語を入力: ");
        String query = scanner.nextLine();
        // リンク先の商品ページから探す語の入力
        System.out.print("型番を入力してください: ");
        String word = scanner.nextLine();
        scanner.close();
        try {
            // InputStreamの用意
            URL url = new URL("https://shopping.yahoo.co.jp/rss?p="
                    + URLEncoder.encode(query, "UTF-8")
                    + "&X=4");   // 2:安い順, 3:高い順, 4:売れている順
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            // DOMツリーの構築
            Document document = viewer.buildDocument(inputStream, "utf-8");
            // XPath の表現を扱う XPath オブジェクトを生成
            XPath xPath = XPathFactory.newInstance().newXPath();

            // item要素のリストを得る
            NodeList itemList = (NodeList) xPath.evaluate("/rss/channel/item",
                    document, XPathConstants.NODESET);

            for (int i = 0; i < itemList.getLength(); i++) {    // 各item要素について
                Node itemNode = itemList.item(i);
                String title = xPath.evaluate("title", itemNode);
                String link = xPath.evaluate("link", itemNode);
                String description = xPath.evaluate("description", itemNode);

                /*
                System.out.println("商品タイトル: " + title);
                System.out.println("説明: " + description.replaceAll("<.+?>", ""));
*/

                // ContextExtractor クラスを用いてリンク先のページ内をチェック
                ContextExtractor extractor = new ContextExtractor();
                String context = extractor.contextSearcher(link, word);
                if (context != null) {
                    System.out.println("商品タイトル: " + title);
                    System.out.println("説明: " + description.replaceAll("<.+?>", ""));

                    System.out.println("リンク先の「" + word + "」を含む行: " + context);
                } else {
                    // System.out.println("リンク先に「" + word + "」を含む行はありません。");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DOM Tree の構築
     */
    public Document buildDocument(InputStream inputStream, String encoding) {
        Document document = null;
        try {
            // DOM実装(implementation)の用意 (Load and Save用)
            DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            DOMImplementationLS implementation = (DOMImplementationLS) registry.getDOMImplementation("XML 1.0");
            // 読み込み対象の用意
            LSInput input = implementation.createLSInput();
            input.setByteStream(inputStream);
            input.setEncoding(encoding);
            // 構文解析器(parser)の用意
            LSParser parser = implementation.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);
            parser.getDomConfig().setParameter("namespaces", false);
            // DOMの構築
            document = parser.parse(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
}
