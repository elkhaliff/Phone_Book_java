package phonebook;

import java.io.File;
import java.util.*;

public class FileReader {
    private final List<String> outList;
    private final Map<String, Integer> hashMap;

    public FileReader(String fileName, boolean splitting) {
        File file = new File(fileName);
        outList = new ArrayList<>();
        hashMap = new HashMap<>();
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

    public FileReader(String fileName) {
        File file = new File(fileName);
        outList = new ArrayList<>();
        hashMap = new HashMap<>();
        try ( Scanner scanner = new Scanner(file) ) {
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().split(" ", 2);
                hashMap.put(line[1], Integer.parseInt(line[0]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getOutMap() { return hashMap; }

    public static List<String> bubbleSort(String[] strings) {
        var time = System.currentTimeMillis();
        var swap = true;
        var shift = 0;
        while (swap) {
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

    public static List<String> quickSort(String[] arrDirect) {
        sorting(arrDirect, 0, arrDirect.length - 1);
        return Arrays.asList(arrDirect);
    }

    private static void sorting(String[] array, int start, int end) {
        int i = start;
        int k = end;
        if (end - start >= 1) {
            String pivot = array[start];
            while (k > i) {
                while (array[i].compareTo(pivot) <= 0 && i <= end && k > i)
                    i++;
                while (array[k].compareTo(pivot) > 0 && k >= start && k >= i)
                    k--;
                if (k > i)
                    swap(array, i, k);
            }
            swap(array, start, k);
            sorting(array, start, k - 1);
            sorting(array, k + 1, end);
        } else { return; }
    }

    private static void swap(String[] array, int index1, int index2) {
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
