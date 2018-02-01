package coursera_oa;
import java.util.*;

public class RoyalName {
    public static void main(String[] args) {
        String[] names = {"Ahh XI", "Ah IX"};
        System.out.println(Arrays.toString(getSortedList(names)));
    }

    public static String[] getSortedList(String[] names) {
        if (names.length == 1) return names;
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");

                int i = compareName(s1[0], s2[0]);

                if (i != -2) return i;
                else {
                    int num1 = romanToInt(s1[1]);
                    int num2 = romanToInt(s2[1]);
                    return num1 - num2;
                }
            }
        });
        return names;
    }

    public static int compareName(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int i = 0;

        while (i < len) {
            if ((s1.charAt(i) - s2.charAt(i)) > 0) return 1;
            else if ((s1.charAt(i) - s2.charAt(i)) < 0) return -1;
            else i++;
        }
        if (s1.length() > len) return 1;
        else if (s2.length() > len) return -1;

        return -2;
    }

    public static int romanToInt(String s) {
        int nums[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X' :
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] < nums[i+1])
                sum -= nums[i];
            else
                sum += nums[i];
        }
        return sum + nums[nums.length - 1];
    }
}
