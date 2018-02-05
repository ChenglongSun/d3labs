package coursera_oa;
import java.util.*;

public class TaskMaster {
    public static void main(String[] args) {
        int n = 10;
        int[] a = {1,3,5};
        int[] b = {2,4,6};
        System.out.println(taskMaster(n, a, b));
    }
    public static int taskMaster(int n, int[] a, int[] b) {
        int[] tasks = new int[n + 1];
        int count = n;
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = i;
        }
        
        for (int i = 0; i < a.length; i++) {
            int pos = a[i];
            int pre = b[i];
            tasks[pos] = tasks[pre];
            int id = pos;

            while (tasks[id] != id) {
                tasks[id] = tasks[tasks[id]];
                id = tasks[id];
            }
            if (tasks[pos] == pos) count--;
        }
        return count;
    }
}
