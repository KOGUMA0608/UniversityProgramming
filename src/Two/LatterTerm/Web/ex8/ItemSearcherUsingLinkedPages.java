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
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemSearcherUsingLinkedPages {

    public static void main(String[] args) {
        //ItemSearcherByWordInTitle viewer = new ItemSearcherByWordInTitle();
        ArrayList<Goods> Goodslist = new ArrayList<Goods>();
        try {
            // URLをInputする
            URL url = new URL("https://shopping.yahoo.co.jp/rss?p=%E6%A3%9A&tab_ex=commerce&oq=&pf=&pt=&ei=UTF-8");
            URL search;
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

            int target = 65;

            for (int i = 0; i < itemNodeList.getLength(); i++) {
                String name;
                int price = 0;
                String idescription;
                String link;
                Node itemNode = itemNodeList.item(i);
                String description = (String) xPath.evaluate("./description/text()", itemNode, XPathConstants.STRING);
                Pattern pattern = Pattern.compile("幅\\d*cm");
                Matcher matcher = pattern.matcher(description);
                Pattern pattern2 = Pattern.compile("\\d*円");
                Matcher matcher2 = pattern.matcher(description);
                String comp2 = matcher.group();
                if (matcher.find()) {
                    String comp = matcher.group();
                    comp = comp.substring(1, comp.indexOf("cm"));
                    //price=comp2;
                    // comp2 = comp2.substring(1, comp.indexOf("cm"));
                    if (target > Integer.parseInt(comp)) {
                        System.out.println("タイトル:" + xPath.evaluate("./title/text()", itemNode, XPathConstants.STRING));
                        System.out.println("リンク:" + xPath.evaluate("./link/text()", itemNode, XPathConstants.STRING));
                        System.out.println("説明文:" + xPath.evaluate("./description/text()", itemNode, XPathConstants.STRING));
                        System.out.println("金額:" + comp2);
                        System.out.println("幅:" + comp);
                    }
                }
                //description.contains(target)
                Goodslist.add(new Goods((String) xPath.evaluate("./title/text()", itemNode, XPathConstants.STRING), Integer.parseInt(comp2), description, (String) xPath.evaluate("./link/text()", itemNode, XPathConstants.STRING)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}