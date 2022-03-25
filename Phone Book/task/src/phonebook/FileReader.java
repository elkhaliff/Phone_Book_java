package phonebook;

import java.io.File;
import java.util.ArrayList;
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

    private boolean bubbleSort(List<String> strings, long timeLimit) {
        var time = System.currentTimeMillis();
        boolean step;


        return true; /*
        for (int i = 0; i < strings.size(); i++) {
            if (i % 1000 == 0) {
                var timeCurr = System.currentTimeMillis() - time;
                if (timeCurr > timeLimit) return false;
            }
            step = false;
            for (int j = 0; j < strings.size() - i; j++) {
                if (strings[j][1] > strings[j + 1][1]) {
                    val tmp = strings[currPos]
                    strings[currPos] = strings[currPos + 1]
                    strings[currPos + 1] = tmp
                    step = true
                }
            }
            if (!step) return true;
        }
        return true;
        */
    }
}
