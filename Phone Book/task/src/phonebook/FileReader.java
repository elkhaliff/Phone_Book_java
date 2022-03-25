package phonebook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private List<String> outList;

    public FileReader(String fileName) {
        File file = new File(fileName);
        outList = new ArrayList<>();
        try ( Scanner scanner = new Scanner(file) ) {
            while (scanner.hasNext())
                outList.add(scanner.nextLine());
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



        for (shift in 0 until (strings.size() - 1)) {
            if (shift % 1000 == 0) {
                val timeCurr = System.currentTimeMillis() - time
                if (timeCurr > timeLimit) return false
            }
            step = false
            for (currPos in 0 until (strings.size - shift - 1)) {
                if (strings[currPos][1] > strings[currPos + 1][1]) {
                    val tmp = strings[currPos]
                    strings[currPos] = strings[currPos + 1]
                    strings[currPos + 1] = tmp
                    step = true
                }
            }
            if (!step) return true;
        }
        return true;
    }
}
