package Two.LatterTerm.Web.ex6;

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

public class ItemSearcherByWordInTitleXPath {
    public static void main(String[] args) {
        //ItemSearcherByWordInTitle viewer = new ItemSearcherByWordInTitle();
        try {
            // URLをInputする
            URL url = new URL("http://kyoko-np.net/index.xml");
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

            String target = "成功";

            for (int i = 0; i < itemNodeList.getLength(); i++) {
                Node itemNode = itemNodeList.item(i);
                String title = (String) xPath.evaluate("./title/text()", itemNode, XPathConstants.STRING);
                if (title.contains(target)) {
                    System.out.println("タイトル:" + title);
                    System.out.println("リンク:" + xPath.evaluate("./link/text()", itemNode, XPathConstants.STRING));
                    System.out.println("説明文:" + xPath.evaluate("./description/text()", itemNode, XPathConstants.STRING));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
