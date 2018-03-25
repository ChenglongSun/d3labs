import java.util.*;

/**
 * Description: 一个数组里面有两个不相重叠的subarray,
 * 		 长度分别是K和L, 求这两个subarray里面所以的elements和最大sum是多少
 */

public class Solution5 {
	public int[] findSubarrayIndex(int[] nums, int K, int L) {
		int len = nums.length;
		int[] sum = new int[len + 1];
		int[] res = new int[2];
		// store the sum array to decrease summing complexity.
		for (int i = 0; i < len; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		//K from left to right
		int[] posLeft = new int[len];
		for (int i = K, tot = sum[K] - sum[0]; i < len; i++) {
			if (sum[i + 1 - K] + sum[i + 1] > tot) {
				posLeft[i] = i + 1 - K;
				tot = sum[i + 1 - K] - sum[i + 1];
			} else {
				posLeft[i] = posLeft[i - 1];
			}
		}

		//int l = 0, r = 0;
		int maxSum = 0;
		for (int i = K; i <= len - 1 - L; i++) {
			int l = posLeft[i - 1];
			int tot = sum[l + K] - sum[l] + sum[i + L] - sum[i];
			if (tot > maxSum) {
				res[0] = l;
				res[1] = i;
				maxSum = tot;
			}
		}
		return res;
	}
	public int getMaxSum(int[] nums, int[] res, int K, int L) {
		int sum = 0;
		int i = res[0];
		int j = res[1];
		while(i < res[0] + K) {
			sum += nums[i++];
		}
		while(j < res[1] + L) {
			sum += nums[j++];
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] nums = {2,2,3,5,7,9,4,1};
		Solution5 s = new Solution5();
		int[] res = s.findSubarrayIndex(nums, 2, 3);
		int ans = s.getMaxSum(nums, res, 2, 3);
		System.out.println(res[0]);
		System.out.println(res[1]);
		System.out.println(ans);
	}
}