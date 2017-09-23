import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            int len=s.length();
            int []arr1=new int[10];
            for(int i=len-1;i>=0;i--){
                if(arr1[s.charAt(i)-48]==0){
                    System.out.print(s.charAt(i)-48);
                    arr1[s.charAt(i)-48]++;
                }
            }
        }
    }
}