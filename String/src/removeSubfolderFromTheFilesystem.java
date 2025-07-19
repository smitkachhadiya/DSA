package DSA.Astring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class removeSubfolderFromTheFilesystem {

    //  1233. Remove Sub-Folders from the Filesystem

    public static List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        for (String s : folder) {
            if (res.isEmpty()) {
                res.add(s);
            } else {
                String prev = res.get(res.size() - 1);
                if (s.startsWith(prev) && s.length() > prev.length() && s.charAt(prev.length()) == '/') {
                    continue;
                } else {
                    res.add(s);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
        System.out.println(removeSubfolders(new String[]{"/a","/a/b/c","/a/b/d"}));
    }
}
