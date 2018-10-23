package Two.LatterTerm.Web.ex5;

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

public class ItemSearcherByWordInTitle {

    public static void main(String[] args) {
        //ItemSearcherByWordInTitle viewer = new ItemSearcherByWordInTitle();
        try {
            // InputStreamの用意
            //URL url = new URL("https://itunes.apple.com/us/rss/topmusicvideos/limit=10/xml");
            // "https://news.yahoo.co.jp/pickup/rss.xml"
            URL url = new URL("http://kyoko-np.net/index.xml");
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            // DOMツリーの構築
            //Document document = viewer.buildDocument(inputStream, "utf-8");
            //viewer.showTree(document.getDocumentElement());

            //下からコピー
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
            //ここまでコピー

            //XPathの作成
            XPathFactory factory = XPathFactory.newInstance();
            XPath xPath = factory.newXPath();

            NodeList itemNodeList = (NodeList) xPath.evaluate("/rss/channel/item",
                    document, XPathConstants.NODESET); // RSS 2.0

            String target = "成功";


            for (int i = 0; i < itemNodeList.getLength(); i++) {
                //System.out.println("hello?");//ここまで来てるのか確認
                Node itemNode = itemNodeList.item(i);
                String title = (String) xPath.evaluate("./title/text()", itemNode, XPathConstants.STRING);
                if (title.contains(target)) {
                    System.out.println("タイトルは" + title);
                    System.out.println("リンクは" + xPath.evaluate("./link/text()", itemNode, XPathConstants.STRING));
                }
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

    /**
     * 引数 node 以下の tree を表示
     */
    public void showTree(Node node) {
        for (Node current = node.getFirstChild();
             current != null;
             current = current.getNextSibling()) {
            if (current.getNodeType() == Node.ELEMENT_NODE) { // ノードは要素?
                String nodeName = current.getNodeName();
                // 中括弧 { } を使って階層を表現
                System.out.println(nodeName + " {");
                showTree(current); // さらに子ノードを見る (再帰)
                System.out.println("}");
            } else if (current.getNodeType() == Node.TEXT_NODE // ノードはテキスト?
                    && current.getNodeValue().trim().length() != 0) {
                System.out.println(current.getNodeValue());
            } else if (current.getNodeType() == Node.CDATA_SECTION_NODE) { // ノードはCDATA?
                System.out.println(current.getNodeValue());
            } // HTMLタグなどを含む
            ; // 上記以外のノードでは何もしない
        }
    }
}
