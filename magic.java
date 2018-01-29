package coursera_oa;
import java.util.*;

public class MagicalBinaryString {
    public static void main(String[] args) {
        String bin = "1101001100";
        String res = magic(bin);
        while (checkMagic(res)) {
            String s = magic(res);
            if (res == s) break;
            else res = s;
        }
        System.out.println(res);
    }

    public static String magic(String s) {
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;
            if (!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            int val = i + 1;
            map.get(count).add(val);
        }

        int max = stringVal(s);
        String res = s;

        for (int key : map.keySet()) {
            if (map.get(key).size() < 3) continue;
            else {
                for (int l = 0; l < map.get(key).size() - 2; l++) {
                    int m = l + 1, r = map.get(key).size() - 1;
                    while (m < r) {
                        String s1 = swap(s, map.get(key).get(l), map.get(key).get(m), map.get(key).get(r));
                        if (checkMagic(s1)) {
                            if (stringVal(s1) > max) {
                                max = stringVal(s1);
                                res = s1;
                            }
                        }
                        m++;
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public static int stringVal(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = count * 2 + (s.charAt(i) - '0');
        }
        return count;
    }

    public static String swap(String s, int i, int j, int k) {
        if (!checkMagic(s.substring(i, j)) || !checkMagic(s.substring(j, k))) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, i));
        sb.append(s.substring(j, k));
        sb.append(s.substring(i, j));
        sb.append(s.substring(k, s.length()));
        return sb.toString();
    }

    public static boolean checkMagic(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;
            if (count < 0) return false;
        }
        return true;
    }

}
