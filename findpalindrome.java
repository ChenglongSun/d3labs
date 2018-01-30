package coursera_oa;
import java.util.*;

public class FindPalindromeSubString {
    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(findPal(s));
    }

    public static HashSet<String> set = new HashSet<>();

    public static int findPal(String s) {

        for (int i = 0; i < s.length(); i++) {
            pal(s, i, i);
            pal(s, i, i + 1);
        }
        return set.size();
    }

    public static void pal(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            set.add(s.substring(i, j + 1));
            i--;
            j++;
        }
    }

}
