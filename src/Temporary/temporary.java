package Temporary;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class temporary {
    int[] frequency = new int[10];
    Scanner scanner = new Scanner(System.in);
    Map<Integer, Double> sort = new TreeMap<>(Comparator.reverseOrder());
    Map<Double, Integer> finalMap = new TreeMap<>(Comparator.reverseOrder());
    Map<Integer, Double> outputMap = new TreeMap<>();

    int n = 327700;
    Map<Integer, Double> dataMap = new HashMap<>();
    Map<Integer, Integer> compMap = new HashMap<>();
    int iso = 10;
    boolean first;
    String filename = scanner.next();

    public static void main(String[] args) {
        temporary temporary = new temporary();
        temporary.input();
        temporary.make();
        temporary.output();
    }

    public void input() {
        System.out.println("波長グラフの名前は?");
        System.out.println("基本波は?");
        int kari = scanner.nextInt();
        int kari2 = kari;
        for (int i = 0; i < frequency.length; i++) {
            frequency[i] = kari;
            kari += kari2;
        }
        try {
            InputStream data = new FileInputStream("./Music/" + filename + ".txt");
            InputStreamReader tmp = new InputStreamReader(data);
            BufferedReader reader = new BufferedReader(tmp);
            for (int i = 0; i < n; i++) {
                String frequency = null;
                String level = null;
                if (!first) {
                    first = true;
                    String notline = reader.readLine();
                    continue;
                }
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                //System.out.println(line);
                String regex = "(\\S*+)(\\s)(\\S+)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    frequency = matcher.group(1);
                    level = matcher.group(3);
                    //ここで精度をDoublからintに変換
                    dataMap.put((int) Math.round(Double.parseDouble(frequency)), Double.valueOf(level));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        for (Integer key : dataMap.keySet()) {
            Double data = dataMap.get(key);
            //System.out.println(key + ": " + data);
        }
    }


    public void make() {
        boolean yes = false;
        int max = 0;
        Map<Integer, Integer> reverseMap = new HashMap<Integer, Integer>();
        int n = 10;
        Double nowMax = (double) 0;
        for (Integer key : dataMap.keySet()) {
            Double data = dataMap.get(key);
            // System.out.println(key + ": " + data);

        }
        for (int i = 0; i < frequency.length; i++) {

            for (Integer key : dataMap.keySet()) {
                Double data = dataMap.get(key);
                if (frequency[i] + iso >= key && frequency[i] - iso <= key) {
                    sort.put(key, data);

                    //System.out.println("周波数"+frequency[i]+"は:"+key + data);


                }
            }

            for (Integer key : sort.keySet()) {
                Double data = sort.get(key);
                if (nowMax < data) {
                    nowMax = data;
                }
                if (!finalMap.containsValue(data)) {
                    finalMap.put(data, key);
                }
            }
            sort.clear();
            System.out.println("周波数" + frequency[i] + "は:");
            for (Double key : finalMap.keySet()) {
                Integer data = finalMap.get(key);
                if (!yes) {
                    yes = true;
                    System.out.println(key + ":" + data);
                    outputMap.put(data, key);
                }
            }
            yes = false;
            finalMap.clear();
        }
    }


    public void output() {
        // ここを作る
        // ファイル名を引数とする
        // 配列arrayをファイルに出力する
        // 1行に1レコード
        System.out.println("出力したいファイルの名前は?");
        //String filename = scanner.next();
        //String filename = "TEST.txt";
        try {
            int i = 1;
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("./A/" + filename + ".txt")));
            for (Integer key : outputMap.keySet()) {
                Double data = outputMap.get(key);
                writer.println("基本波" + key + "Hz " + data + "dB");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

/*
String regex = "[『「](.*?)[』」]";
        Pattern pattern = Pattern.compile(regex);
        List<Item> itemList = list;
        for (Item item : itemList) {
            Matcher matcher = pattern.matcher(item.title);
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
        }
        spectrum.txt
 */