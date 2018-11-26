package Two.LatterTerm.Web.ex8;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSParser;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Goods {
    String name;
    int price;
    String description;
    String link;
    ArrayList text = new ArrayList();

    ArrayList<Goods> itemList = new ArrayList<Goods>();

    Goods(String name, int price, String description, String link) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.link = link;
    }

    Goods(String name, String link) {
        this.name = name;
        this.link = link;
        input();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    void input(){
        try {
            // URLをInputする
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            //URLをインプットする(ここまで)

            // DOM実装(implementation)の用意 (Load and Save用)
            DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            DOMImplementationLS implementation = (DOMImplementationLS) registry.getDOMImplementation("XML 1.0");
            // 読み込み対象の用意
            LSInput input = implementation.createLSInput();
            input.setByteStream(inputStream);
            input.setEncoding("UTF-8");
            // 構文解析器(parser)の用意
            LSParser parser = implementation.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);
            parser.getDomConfig().setParameter("namespaces", false);
            // DOMの構築
            Document document = parser.parse(input);

            //XPathの作成
            XPathFactory factory = XPathFactory.newInstance();
            XPath xPath = factory.newXPath();

            NodeList itemNodeList = (NodeList) xPath.evaluate("/rss/channel/item",
                    document, XPathConstants.NODESET); // RSS 2.0

            for (int i = 0; i < itemNodeList.getLength(); i++) {
                String name;
                int price = 0;
                String idescription;
                String link;
                Node itemNode = itemNodeList.item(i);
                //タイトルとリンクをGoodslistに追加
                itemList.add(new Goods((String) xPath.evaluate("./title/text()", itemNode, XPathConstants.STRING), (String) xPath.evaluate("./link/text()", itemNode, XPathConstants.STRING)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // URLオブジェクトを生成
            URL url = new URL(link);
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
                text.add(line);
            }
            reader.close();
            //} catch (FileNotFoundException e) {
            //    System.out.println(filename + "が見つかりません。");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}