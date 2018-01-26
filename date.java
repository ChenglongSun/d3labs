package coursera_oa;
import java.util.*;

public class ReformattingData {
    public static void main(String[] args) {
        String date = "16th Jan 1900";
        System.out.println(reformate(date));
    }
    public  static String reformate(String str) {
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        StringBuilder sb = new StringBuilder();
        String[] date = str.split(" ");
        sb.append(date[2]);
        sb.append('-');
        for (int i = 0; i < month.length; i++) {
            if (month[i].equals(date[1])) {
                int mon = i + 1;
                if (mon < 10) {
                    sb.append('0');
                }
                    sb.append(mon);
                    sb.append('-');
            }
        }
        if (date[0].length() == 3) sb.append('0');
        for (char c : date[0].toCharArray()) {
            if (c >= '0' && c <= '9') sb.append(c);
        }
        return sb.toString();
    }
}