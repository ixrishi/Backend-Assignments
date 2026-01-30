//ways to read and write the file
// FileReader / FileWriter slow speed  || reads character by character || fr.read() fw.write("text")
// BufferedReader / BufferedWriter fast speed ||line by line || br.readLine() bw.write()
// Scanner / PrintWriter average speed  || sc.hasNextLine() | sc.nextLine()  pw.println() pw.printf()||
// FileInputStream / FileOutputStream  fast 
// NIO (Files, Paths, Channels) very fast 

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Problem1 {

    static class Item {

        String s;
        Integer freq;

        public Item(String s, Integer freq) {
            this.s = s;
            this.freq = freq;
        }

    }

    public static void main(String[] args) throws Exception {
        try {

            File file = new File("data.txt");
            // file.exists()
            if (file.createNewFile()) {
                System.out.println("File created");
            }

            // System.out.println(file.getPath()); //return string 
            Path path = Path.of("data.txt");

            // System.out.println( path); //returns object 
            int sentences = 0;
            int words = 0;
            int characters = 0;
            HashMap<String, Integer> map = new HashMap<>();

            PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));
            Stream<String> stream = Files.lines(path);

            try {
                for (String line : (Iterable<String>) stream::iterator) {
                    for (String i : line.split("\\s+")) {
                        words++;
                        characters += line.replaceAll("\\s+", "").length();
                        ;
                        i = i.toLowerCase();
                        map.put(i, map.getOrDefault(i, 0) + 1);
                    }

                }
            } finally {
                if (stream != null) {
                    stream.close();
                }
            }

            //changing tab space to space
            String content = Files.readString(path);
            content = content.replaceAll("\\s+", " ").trim();
            Files.writeString(path, content);

            //reversing the sentences
            String contentsplit[] = content.split("(?<=[.!?])");
            StringBuilder res = new StringBuilder();
            for (String i : contentsplit) {
                sentences++;
                res.append(new StringBuilder(i).reverse());
            }
            Files.writeString(path, res);

            for (String i : map.keySet()) {
                pq.offer(new Item(i, map.get(i)));
            }

            System.out.println("Lines: " + sentences);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + characters);
            System.out.println("top 5 most frequent words");
            for (int i = 0; i < 5; i++) {
                if (pq.isEmpty()) {
                    break;
                }
                System.out.print(pq.poll().s + " ");
            }
            System.out.println();

            // == and . equals()
            String wordSplit[] = Files.readString(path).split(" ");
            for (String i : wordSplit) {
                for (String j : wordSplit) {
                    if (i == j) {
                        System.out.println("The word: " + i + " " + j + " have same memory location");
                    }
                    if (i.equals(j)) {
                        System.out.println("The word: " + i + " " + j + " are same words");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
