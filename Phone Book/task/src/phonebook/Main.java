package phonebook;

import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var formatter = new SimpleDateFormat("m 'min.' s 'sec.' S 'ms.'");
        long time;
        int found;
        String timeTaken;
        var prefix = "D:/test/";
        var fileFind = prefix + "find.txt";
        var fileDir = prefix + "directory.txt";
        var fileDirOut = prefix + "directory_out.txt";

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
        listDir = new FileReader(fileDirOut, true).getOutList();
        listDir = FileReader.bubbleSort(listDir.toArray(new String[0]));
        timeTaken = formatter.format((System.currentTimeMillis() - time));

        finder = new Finder(listFind, listDir.toArray(new String[0]));
        time = System.currentTimeMillis();
        found = finder.jumpSearch();
        var timeTakenSearch = formatter.format((System.currentTimeMillis() - time));
        println(String.format("Found %d / %d entries. Time taken: %s.", found, listFind.size(), timeTaken));

        println(String.format("Sorting time: %s.", timeTaken));
        println(String.format("Searching time: %s.", timeTakenSearch));


        println("Start searching (quick sort + binary search)...");
        time = System.currentTimeMillis();
        listDir = new FileReader(fileDir, true).getOutList();
        listDir = FileReader.quickSort(listDir.toArray(new String[0]));
        timeTaken = formatter.format((System.currentTimeMillis() - time));

        finder = new Finder(listFind, listDir.toArray(new String[0]));
        time = System.currentTimeMillis();
        found = finder.binarySearch();
        timeTakenSearch = formatter.format((System.currentTimeMillis() - time));
        println(String.format("Found %d / %d entries. Time taken: %s.", found, listFind.size(), timeTaken));

        println(String.format("Sorting time: %s.", timeTaken));
        println(String.format("Searching time: %s.", timeTakenSearch));
    }

    public static void println(String str) { System.out.println(str); }
}
