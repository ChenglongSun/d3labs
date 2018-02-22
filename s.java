public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }


            if (nums[mid] == nums[end]) { // 增加两个比对
                end--;
            } else if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        return nums[start] == target ? true : nums[end] == target;
    }
}