class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target < nums[0]) {
                if (nums[mid] < nums[0] && nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] > nums[0] && nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return (nums[left] == target)? left : (nums[right] == target)? right : -1;
    }
}