package phonebook;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private List<String> outList;

    public FileReader(String fileName, boolean splitting) {
        File file = new File(fileName);
        outList = new ArrayList<>();
        try ( Scanner scanner = new Scanner(file) ) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                outList.add(splitting ? line.split(" ", 2)[1] : line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getOutList() {
        return outList;
    }

    public static List<String> bubbleSort(String[] strings, long timeLimit) {
        var time = System.currentTimeMillis();
        var swap = true;
        var shift = 0;
        while (swap) {
            if (shift % 1000 == 0) {
                var timeCurr = System.currentTimeMillis() - time;
               // if (timeCurr > timeLimit) return null;
            }
            swap = false;
            for (int j = 0; j < strings.length - shift - 1; j++) {
                if (strings[j].compareTo(strings[j + 1]) > 0) {
                    var tmp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = tmp;
                    swap = true;
                }
            }
            shift++;
        }
        return Arrays.asList(strings);
    }
}
