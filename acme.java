package coursera_oa;
import java.util.*;

public class AcmeSubstring {
    public static void main(String[] args) {
        String a = "aaaathsathisisatest";
        String x = "th*s";
        System.out.println(acme(a, x));
    }
    
    public static int acme(String a, String x) {
        for (int i = 0; ;i++) {
            for (int j = 0; ;j++) {
                if (j == x.length()) return i;
                if (i + j == a.length()) return -1;
                if (x.charAt(j) == '*') continue;
                if (a.charAt(i + j) != x.charAt(j)) break;
            }
        }
    }
}
