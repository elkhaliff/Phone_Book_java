package phonebook;

import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var formatter = new SimpleDateFormat("m 'min.' s 'sec.' S 'ms.'");
        long time;
        int found;
        String timeTaken;
        var fileFind = "D:/test/find.txt";
        var fileDir = "D:/test/directory_out.txt";
        long timeLimit = 10000;

        List<String> listFind = new FileReader(fileFind, false).getOutList();
        List<String> listDir = new FileReader(fileDir, true).getOutList();

        Finder finder = new Finder(listFind, listDir);

        println("Start searching (linear search)...");
        time = System.currentTimeMillis();
        found = finder.linearSearch();
        timeTaken = formatter.format((System.currentTimeMillis() - time));
        println(String.format("Found %d / %d entries. Time taken: %s.", found, listFind.size(), timeTaken));


        println("Start searching (bubble sort + jump search)...");
        time = System.currentTimeMillis();
        listDir = FileReader.bubbleSort(listDir.toArray(new String[0]), timeLimit);
        timeTaken = formatter.format((System.currentTimeMillis() - time));
        println(String.format("Sorting time: %s.", timeTaken));

        finder = new Finder(listFind, listDir.toArray(new String[0]));
        time = System.currentTimeMillis();
        found = finder.jumpSearch();
        timeTaken = formatter.format((System.currentTimeMillis() - time));
        println(String.format("Found %d / %d entries. Time taken: %s.", found, listFind.size(), timeTaken));

    }

    public static void println(String str) { System.out.println(str); }
}
