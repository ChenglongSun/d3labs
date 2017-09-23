//1~~~~
import java.util.*;

public class Main {
	public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        
        int digit = countDigit(str);
        System.out.println(digit);
        String read = readDigit(str);
        System.out.println(read);
        String rev = reverse(str);
        System.out.println(rev);
        
    }
    
    public static int countDigit(String str) {
    	if (str.charAt(0) == '-') {
        	return str.length() - 1;
        }
        return str.length();
    }
    public static String readDigit(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++){
            sb.append(str.charAt(i));
            sb.append(' ');
        }
        sb.append(str.charAt(str.length() - 1));
        if (str.charAt(0) == '-') {
            sb.deleteCharAt(1);
        }
        return sb.toString();
    }
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (str.charAt(0) == '-') {
            sb.deleteCharAt(0);
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}




//2~~~~

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = new String[4];
        int i = 0;
        while (i < 4){
            str[i++] = scan.nextLine();
        }
        if ((compare(str[1], str[2]) < 0) ||(compare(str[3], str[0]) < 0)) {
            System.out.println("No Overlap IP");
        } else {
            System.out.println("Overlap IP");
        }
        
    }
    public static int compare(String s1, String s2) {
        String[] a = s1.split("\\.");
        String[] b = s2.split("\\.");
        for (int i = 0; i < 4; i++) {
            if (a[i].equals(b[i])) {
                continue;
            } else {
                return a[i].compareTo(b[i]);
            }
        }
        return 0;
    }
}

//3~~~~

import java.util.*;
public class Main{
    static class MyNum{
        int original;
        int simplify;
        public MyNum(int original, int simplify) {
            this.original = original;
            this.simplify = simplify;
        }
    }
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
   		String str = scan.nextLine();
        
    	String[] numbers = str.split(" ");
        MyNum[] myNums = new MyNum[numbers.length];
        
        
        for (int i = 0; i < myNums.length; i++) {
            String trunc = truncate(numbers[i]);
            myNums[i] = new MyNum(Integer.parseInt(numbers[i]), Integer.parseInt(trunc));
        }
        
        
   		Arrays.sort(myNums, new Comparator<MyNum>(){
            @Override
            public int compare(MyNum n1, MyNum n2) {
                if ((n1.simplify) == (n2.simplify)) {
                    return 0;
                } 
                return (n1.simplify) - (n2.simplify);
            }
        });
        System.out.println(myNums[scan.nextInt() - 1].original);
    }
    
    public static String truncate(String s1) {
        if (s1.length() <= 3) {
            return s1;
        }
        return s1.substring(s1.length() - 3);
    }
}