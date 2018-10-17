package Two.LatterTerm.Web.ex5;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSParser;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ItemSearcherByWordInTitle {
    public static void main(String[] args) {
        ItemSearcherByWordInTitle viewer = new ItemSearcherByWordInTitle();
        try {
            // InputStreamの用意
            //URL url = new URL("https://itunes.apple.com/us/rss/topmusicvideos/limit=10/xml");
            // "https://news.yahoo.co.jp/pickup/rss.xml"
            URL url = new URL("http://kyoko-np.net/index.xml");
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            // DOMツリーの構築
            Document document = viewer.buildDocument(inputStream, "utf-8");
            viewer.showTree(document.getDocumentElement());
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
            String str = current.getNodeValue();
            if (current.getNodeType() == Node.ELEMENT_NODE) { // ノードは要素?
                String nodeName = current.getNodeName();
                if (nodeName.equals("item")) {
                    //この下の階層にはタイトルとリンクが有ることが確定

                    for (Node tmpcurrent = current.getNextSibling();
                         current != null;
                         current = current.getNextSibling()) {
                        if (tmpcurrent.getNodeName().equals("虚構新聞")) {
                        }
                        System.out.println(current.getNodeValue());
                    }
                }
                // 中括弧 { } を使って階層を表現
                System.out.println(nodeName + " {");
                showTree(current); // さらに子ノードを見る (再帰)
                System.out.println("}");
            }
            /*
            else if (current.getNodeType() == Node.TEXT_NODE // ノードはテキスト?
                    && current.getNodeValue().trim().length() != 0) {
                System.out.println(current.getNodeValue());
            } else if (current.getNodeType() == Node.CDATA_SECTION_NODE) { // ノードはCDATA?
                System.out.println(current.getNodeValue());
            }
            */
            // HTMLタグなどを含む
            ; // 上記以外のノードでは何もしない
        }
    }
}
/*
public void showTree(Node node) {
        for (Node current = node.getFirstChild();
             current != null;
             current = current.getNextSibling()) {
            String str = current.getNodeValue();
            if (current.getNodeType() == Node.ELEMENT_NODE) { // ノードは要素?
                String nodeName = current.getNodeName();
                // 中括弧 { } を使って階層を表現
                System.out.println(nodeName + " {");
                showTree(current); // さらに子ノードを見る (再帰)
                System.out.println("}");
            }

            else if (current.getNodeType() == Node.TEXT_NODE // ノードはテキスト?
                    && current.getNodeValue().trim().length() != 0) {
                System.out.println(current.getNodeValue());
            } else if (current.getNodeType() == Node.CDATA_SECTION_NODE) { // ノードはCDATA?
                System.out.println(current.getNodeValue());
            } // HTMLタグなどを含む
            ; // 上記以外のノードでは何もしない
        }
    }
 */
/*
public void showTree(Node node) {
        for (Node current = node.getFirstChild();
             current != null;
             current = current.getNextSibling()) {
            String str;
            if (current.getNodeType() == Node.ELEMENT_NODE) { // ノードは要素?
                String nodeName = current.getNodeName();
                // 中括弧 { } を使って階層を表現
                System.out.println(nodeName + " {");
                str = current.getNodeValue();
                if (nodeName.equals("title")) {
                    //タイトルタグ限定
                    if (str.equals("虚構新聞")) {
                        if (current.getNodeType() == Node.TEXT_NODE // ノードはテキスト?
                                && current.getNodeValue().trim().length() != 0) {
                            System.out.println(current.getNodeValue());
                        } else if (current.getNodeType() == Node.CDATA_SECTION_NODE) { // ノードはCDATA?
                            System.out.println(current.getNodeValue());
                        }
                    }
                }
                showTree(current); // さらに子ノードを見る (再帰)
                System.out.println("}");
            }  // HTMLタグなどを含む
            ; // 上記以外のノードでは何もしない
        }
    }
 */
