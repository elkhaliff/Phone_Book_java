package phonebook;

import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        println("Start searching...");
        var formatter = new SimpleDateFormat("m 'min.' s 'sec.' S 'ms.'");
        var time = System.currentTimeMillis();
        var fileFind = "D:/test/find.txt";
        var fileDir = "D:/test/directory.txt";

        List<String> listFind = new FileReader(fileFind, false).getOutList();
        List<String> listDir = new FileReader(fileDir, true).getOutList();

        var found = 0;
        for (String find: listFind) {
            if (listDir.contains(find)) found ++;
        }
        var timeTaken = formatter.format((System.currentTimeMillis() - time));
        println(String.format("Found %d / %d entries. Time taken: %s.", found, listFind.size(), timeTaken));
    }

    public static void println(String str) { System.out.println(str); }
}
