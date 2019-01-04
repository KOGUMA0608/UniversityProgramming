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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WebLast {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> totalMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> forgamerMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> notForgamerMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> gamesparkMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> notGamesparkMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> gamewatchMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> notGamewatchMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> insideMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> notInsideMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> filalMap = new LinkedHashMap<>();
        ElementCounter elementCounter = new ElementCounter();
        ArrayList<String> gameName = new ArrayList();
        WebLast webLast = new WebLast();

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
            webLast.extractGameName(steamNewsItemList, gameName);
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
            webLast.extractGameName(steamTopSellingItemList, gameName);
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }

        List<Item> forgamerItemList = new ArrayList<Item>();
        ArrayList<String> forgamerElements = new ArrayList();
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
            webLast.extractGameName(forgamerItemList, forgamerElements);
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }
        List<Item> gamesparkItemList = new ArrayList<Item>();
        ArrayList<String> gamesparkElements = new ArrayList();
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
            webLast.extractGameName(gamesparkItemList, gamesparkElements);
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }
        List<Item> gamewatchItemList = new ArrayList<Item>();
        ArrayList<String> gamewatchElements = new ArrayList();
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
            webLast.extractGameName(gamewatchItemList, gamewatchElements);
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }

        List<Item> insideItemList = new ArrayList<Item>();
        ArrayList<String> insideElements = new ArrayList();
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
            webLast.extractGameName(insideItemList, insideElements);
        } catch (MalformedURLException | XPathExpressionException event) {
            //XPathExpressionException event
            event.printStackTrace();
        }
//全要素表示
/*
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
        for (Item item : forgamerItemList) {
            //System.out.println(item.title);
            // System.out.println(item.description);
            //  System.out.println(item.link);
        }
        System.out.println("Forgamer");
        for (String string : forgamerElements) {
            System.out.println(string);
        }
        System.out.println("Gamespark");
        for (String string : gamesparkElements) {
            System.out.println(string);
        }
        System.out.println("Gamewatch");
        for (String string : gamewatchElements) {
            System.out.println(string);
        }
        System.out.println("Inside");
        for (String string : insideElements) {
            System.out.println(string);
        }
*/
        //全体図
        elementCounter.mapping(totalMap, forgamerElements);
        elementCounter.mapping(totalMap, gamesparkElements);
        elementCounter.mapping(totalMap, gamewatchElements);
        elementCounter.mapping(totalMap, insideElements);

        //forgamerとそうでは無い物
        elementCounter.mapping(forgamerMap, forgamerElements);
        elementCounter.mapping(notForgamerMap, gamesparkElements);
        elementCounter.mapping(notForgamerMap, gamewatchElements);
        elementCounter.mapping(notForgamerMap, insideElements);

        //gamesparkとそうでは無い物
        elementCounter.mapping(gamesparkMap, gamesparkElements);
        elementCounter.mapping(notGamesparkMap, forgamerElements);
        elementCounter.mapping(notGamesparkMap, gamewatchElements);
        elementCounter.mapping(notGamesparkMap, insideElements);

        //gamewatchとそうでは無い物
        elementCounter.mapping(gamewatchMap, gamewatchElements);
        elementCounter.mapping(notGamewatchMap, forgamerElements);
        elementCounter.mapping(notGamewatchMap, gamesparkElements);
        elementCounter.mapping(notGamewatchMap, insideElements);

        //insideとそうでは無い物
        elementCounter.mapping(insideMap, insideElements);
        elementCounter.mapping(notInsideMap, forgamerElements);
        elementCounter.mapping(notInsideMap, gamesparkElements);
        elementCounter.mapping(notInsideMap, gamewatchElements);

        for (String comp : forgamerMap.keySet()) {
            for (String notComp : notForgamerMap.keySet()) {
                if (comp.equals(notComp)) {
                    filalMap.put(comp, forgamerMap.get(comp));
                    break;
                }
            }
        }
        for (String comp : gamesparkMap.keySet()) {
            for (String notComp : notGamesparkMap.keySet()) {
                if (comp.equals(notComp)) {
                    filalMap.put(comp, gamesparkMap.get(comp));
                    break;
                }
            }
        }
        for (String comp : gamewatchMap.keySet()) {
            for (String notComp : notGamewatchMap.keySet()) {
                if (comp.equals(notComp)) {
                    filalMap.put(comp, gamewatchMap.get(comp));
                    break;
                }
            }
        }
        for (String comp : insideMap.keySet()) {
            for (String notComp : notInsideMap.keySet()) {
                if (comp.equals(notComp)) {
                    filalMap.put(comp, insideMap.get(comp));
                    break;
                }
            }
        }
        //System.out.println(filalMap.keySet());
        ArrayList<String> finalList = new ArrayList<String>(filalMap.keySet());
        for (String finalString : finalList) {
            if (totalMap.containsKey(finalString)) {
                System.out.println(finalString + "=>" + totalMap.get(finalString));
            }
        }

        //回数順でソートするためのlist
        List<Map.Entry<String,Integer>> entries =
                new ArrayList<Map.Entry<String,Integer>>(finalList.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String,Integer>>() {

            @Override
            public int compare(
                    Entry<String,Integer> entry1, Entry<String,Integer> entry2) {
                return ((Integer)entry2.getValue()).compareTo((Integer)entry1.getValue());
            }
        });

        // 内容を表示
        for (Entry<String,Integer> s : entries) {
            System.out.println("s.getKey() : " + s.getKey());
            System.out.println("s.getValue() : " + s.getValue());
        }
    }



    //鍵括弧内(主にゲーム名)のみ抽出
    void extractGameName(List list, ArrayList arrayList) {
        String regex = "[『「](.*?)[』」]";
        Pattern pattern = Pattern.compile(regex);
        List<Item> itemList = list;
        for (Item item : itemList) {
            Matcher matcher = pattern.matcher(item.title);
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
        }
    }
    /*
    void extractGameName(List list, ArrayList arrayList) {
        String regex = ".*『(.*)』.*|.*「(.*)」.*";
        Pattern pattern = Pattern.compile(regex);
        List<Item> itemList = list;
        for (Item item : itemList) {
            Matcher matcher = pattern.matcher(item.title);
            if (matcher.find()) {
                arrayList.add(item.title);
            }
        }
    }
     */

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
