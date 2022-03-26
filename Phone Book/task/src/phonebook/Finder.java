package phonebook;

import java.util.List;

public class Finder {
    List<String> listFind;
    List<String> listDir;
    String[] arrDirect;

    public Finder(List<String> f, List<String> d) {
        listFind = f;
        listDir = d;
    }

    public Finder(List<String> f, String[] d) {
        listFind = f;
        arrDirect = d;
    }

    public int linearSearch(){
        var found = 0;
        for (String find: listFind) {
            for (String dir: listDir) {
                if (dir.equals(find)) { found ++; continue; }
            }
        }
        return found;
    }

    private int backwardSearch(String findStr, int currPos, int prevPos) {
        for (int i = currPos; i >= prevPos; i--) {
            if (findStr.equals(arrDirect[i])) return 1;
        }
        return 0;
    }

    public int jumpSearch(){
        var found = 0;
        int blockSize = (int) Math.floor(Math.sqrt(arrDirect.length));
        for (String find: listFind) {
            var currBlock = 0;
            if (arrDirect[currBlock].contains(find)) {
                found++;
                continue;
            }
            while (currBlock < arrDirect.length - 1) {
                currBlock = Math.min(arrDirect.length - 1, currBlock + blockSize);
                if (find.compareTo(arrDirect[currBlock]) <= 0)
                    break;
            }
            found += (currBlock == arrDirect.length - 1 && find.compareTo(arrDirect[currBlock]) > 0) ? 0 :
                        backwardSearch(find, currBlock, currBlock - blockSize);
        }
        return found;
    }


    private int binarySearch_(String elem, int left, int right) {
        if (left > right) return 0;
        int mid = left + (right - left) / 2;
        if (elem.equals(arrDirect[mid])) return 1;
        if (elem.compareTo(arrDirect[mid]) < 0) return binarySearch_(elem, left, mid - 1);
        else return binarySearch_(elem, mid + 1, right);
    }

    public int binarySearch() {
        var found = 0;
        for (String find: listFind) {
            found += binarySearch_(find, 0, arrDirect.length - 1);
        }
        return found;
    }
}
