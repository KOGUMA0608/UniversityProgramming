package Two.LatterTerm.Web.last;

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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class WebLast {
    public static void main(String[] args) {
        List<Item> steamNewsItemList = new ArrayList<Item>();
        try {
            //steam用
            Document steamNews = ConvertURLToXML(new URL("https://store.steampowered.com/feeds/news.xml"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList itemNodeList = (NodeList) xPath.evaluate("//item", steamNews, XPathConstants.NODESET);
            for (int i = 0; i < itemNodeList.getLength(); i++) {
                Node node = itemNodeList.item(i);
                String title = (String) xPath.evaluate("title/text()", node, XPathConstants.STRING);
                String description = (String) xPath.evaluate("description/text()", node, XPathConstants.STRING);
                String link = (String) xPath.evaluate("link/text()", node, XPathConstants.STRING);
                steamNewsItemList.add(new Item(title, description, link));
            }
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }

        List<Item> steamTopSellingItemList = new ArrayList<Item>();
        try {
            //steam用
            Document steamTopSelling = ConvertURLToXML(new URL("https://store.steampowered.com/feeds/weeklytopsellers.xml"));
            //Document steam = ConvertURLToXML(new URL("https://www.kuroneko-square.net/services/amazon/rest?api=ItemSearch&Keywords=https%3A%2F%2Fwww.amazon.co.jp%2Fgp%2Frss%2Fbestsellers%2Fsoftware%2F689132%2Fref%3Dzg_bs_689132_rsslink&SearchIndex=All&MinimumPrice=&MaximumPrice=&format=rdf"));
            //Document steam = ConvertURLToXML(new URL("https://www.amazon.co.jp/gp/rss/bestsellers/software/689132/ref=zg_bs_689132_rsslink.xml"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList itemNodeList = (NodeList) xPath.evaluate("//item", steamTopSelling, XPathConstants.NODESET);
            for (int i = 0; i < itemNodeList.getLength(); i++) {
                Node node = itemNodeList.item(i);
                String title = (String) xPath.evaluate("title/text()", node, XPathConstants.STRING);
                String description = (String) xPath.evaluate("description/text()", node, XPathConstants.STRING);
                String link = (String) xPath.evaluate("link/text()", node, XPathConstants.STRING);
                steamTopSellingItemList.add(new Item(title, description, link));
            }
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }

        List<Item> forgamerItemList = new ArrayList<Item>();

        try {
            //Forgamer用
            Document Forgamer = ConvertURLToXMLByBrowser(new URL("https://www.4gamer.net/rss/pc/pc_news.xml"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList itemNodeList = (NodeList) xPath.evaluate("//item", Forgamer, XPathConstants.NODESET);
            for (int i = 0; i < itemNodeList.getLength(); i++) {
                Node node = itemNodeList.item(i);
                String title = (String) xPath.evaluate("title/text()", node, XPathConstants.STRING);
                String description = (String) xPath.evaluate("description/text()", node, XPathConstants.STRING);
                String link = (String) xPath.evaluate("link/text()", node, XPathConstants.STRING);
                forgamerItemList.add(new Item(title, description, link));
            }
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }
        List<Item> gamesparkItemList = new ArrayList<Item>();

        try {
            //gamespark用
            Document Gamespark = ConvertURLToXMLByBrowser(new URL("https://www.gamespark.jp/rss/index.rdf"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList itemNodeList = (NodeList) xPath.evaluate("//item", Gamespark, XPathConstants.NODESET);
            for (int i = 0; i < itemNodeList.getLength(); i++) {
                Node node = itemNodeList.item(i);
                String title = (String) xPath.evaluate("title/text()", node, XPathConstants.STRING);
                String description = (String) xPath.evaluate("description/text()", node, XPathConstants.STRING);
                String link = (String) xPath.evaluate("link/text()", node, XPathConstants.STRING);
                gamesparkItemList.add(new Item(title, description, link));
            }
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }
        List<Item> gamewatchItemList = new ArrayList<Item>();
        try {
            //gamewatch用
            Document Gamewatch = ConvertURLToXMLByBrowser(new URL("https://game.watch.impress.co.jp/data/rss/1.0/gmw/feed.rdf"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList itemNodeList = (NodeList) xPath.evaluate("//item", Gamewatch, XPathConstants.NODESET);
            for (int i = 0; i < itemNodeList.getLength(); i++) {
                Node node = itemNodeList.item(i);
                String title = (String) xPath.evaluate("title/text()", node, XPathConstants.STRING);
                String description = (String) xPath.evaluate("description/text()", node, XPathConstants.STRING);
                String link = (String) xPath.evaluate("link/text()", node, XPathConstants.STRING);
                gamewatchItemList.add(new Item(title, description, link));
            }
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }

        List<Item> insideItemList = new ArrayList<Item>();
        try {
            //inside用
            Document inside = ConvertURLToXMLByBrowser(new URL("https://www.inside-games.jp/rss/index.rdf"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList itemNodeList = (NodeList) xPath.evaluate("//item", inside, XPathConstants.NODESET);
            for (int i = 0; i < itemNodeList.getLength(); i++) {
                Node node = itemNodeList.item(i);
                String title = (String) xPath.evaluate("title/text()", node, XPathConstants.STRING);
                String description = (String) xPath.evaluate("description/text()", node, XPathConstants.STRING);
                String link = (String) xPath.evaluate("link/text()", node, XPathConstants.STRING);
                insideItemList.add(new Item(title, description, link));
            }
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }
/*全要素表示
        for (Item item : steamNewsItemList) {
            System.out.println(item.title);
            System.out.println(item.description);
            System.out.println(item.link);
        }
        for (Item item : steamTopSellingItemList) {
            System.out.println(item.title);
            System.out.println(item.description);
            System.out.println(item.link);
        }
        for (Item item : forgamerItemList) {
            System.out.println(item.title);
            System.out.println(item.description);
            System.out.println(item.link);
        }
        for (Item item : gamesparkItemList) {
            System.out.println(item.title);
            System.out.println(item.description);
            System.out.println(item.link);
        }
        for (Item item : gamewatchItemList) {
            System.out.println(item.title);
            System.out.println(item.description);
            System.out.println(item.link);
        }
        for (Item item : insideItemList) {
            System.out.println(item.title);
            System.out.println(item.description);
            System.out.println(item.link);
        }
        */
//鍵括弧内(主にゲーム名)のみ抽出

    }

    static Document ConvertURLToXML(URL url) {
        try {
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            //inputStream.skip(0);
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

    static Document ConvertURLToXMLByBrowser(URL url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozila/5.0(Windows NT 6.1;WOW64)");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
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

    static Document ConvertURLToHTML(URL url) {
        try {
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            //inputStream.skip(0);
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
