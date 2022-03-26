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
}
