package Two.LatterTerm.Web.ex11;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSParser;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class SearchData {
    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<Item>();
        try {
            Document steam = ConvertURLToXML(new URL("https://store.steampowered.com/feeds/weeklytopsellers.xml"));
            //Document steam = ConvertURLToXML(new URL("https://www.kuroneko-square.net/services/amazon/rest?api=ItemSearch&Keywords=https%3A%2F%2Fwww.amazon.co.jp%2Fgp%2Frss%2Fbestsellers%2Fsoftware%2F689132%2Fref%3Dzg_bs_689132_rsslink&SearchIndex=All&MinimumPrice=&MaximumPrice=&format=rdf"));
            Document amazon = ConvertURLToXML(new URL("https://www.amazon.co.jp/gp/rss/bestsellers/software/689132/ref=zg_bs_689132_rsslink"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList itemNodeList = (NodeList) xPath.evaluate("//item", steam, XPathConstants.NODESET);
            for (int i = 0; i < itemNodeList.getLength(); i++) {
                Node node = itemNodeList.item(i);
                String title = (String) xPath.evaluate("title/text()", node, XPathConstants.STRING);
                String description = (String) xPath.evaluate("description/text()", node, XPathConstants.STRING);
                String link = (String) xPath.evaluate("link/text()", node, XPathConstants.STRING);
                itemList.add(new Item(title, description, link));
            }
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }

        for (Item item : itemList) {
            System.out.println(item.title);
        }
    }

    static Document ConvertURLToXML(URL url) {
        try {
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();

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
            return parser.parse(input);
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
