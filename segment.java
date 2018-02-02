package coursera_oa;
import java.util.*;

public class Segment {
    public static void  main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2};
        int k = 2;
        System.out.println(segment(nums, k));
    }
    public static int segment(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] >= nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (i >= k - 1) {
                ans = Math.max(ans, nums[dq.peek()]);
            }
        }
        return ans;
    }
}
