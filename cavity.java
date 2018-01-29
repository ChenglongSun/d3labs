package coursera_oa;
import java.util.*;

public class CavityMap {
    public static void main(String[] args) {
        String[] map = {"1112",
                        "1912",
                        "1892",
                        "1234"};
        System.out.println(Arrays.toString(cav(map)));
    }
    public static String[] cav(String[] map) {
        String[] res = new String[map.length];
        res[0] = map[0];
        for (int i = 1; i < map.length - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(map[i].charAt(0));
            for (int j = 1; j < map[0].length() - 1; j++) {
                if (check(map, i, j)) sb.append('X');
                else sb.append(map[i].charAt(j));
            }
            sb.append(map[i].charAt(map[0].length() - 1));
            res[i] = sb.toString();
        }
        res[res.length - 1] = map[map.length - 1];
        return res;
    }
    public static boolean check(String[] map, int i, int j) {
        int val = map[i].charAt(j) - '0';
        int val1 = map[i - 1].charAt(j) - '0';
        int val2 = map[i + 1].charAt(j) - '0';
        int val3 = map[i].charAt(j - 1) - '0';
        int val4 = map[i].charAt(j + 1) - '0';
        if (val > val1 && val > val2 && val > val3 && val > val4) return true;
        return false;
    }
}
