class Solution {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }
    
    public int helper(int[] nums, int start, int end, int target) {
        if (start == end) return nums[start];
        int pivot = nums[(start + (end - start) / 2)];
        int left = start;
        int right = end;
        while (left <= right) {
            while (nums[left] > pivot) {
                left++;
            }
            while (nums[right] < pivot) {
                right--;
            }

            if (left <= right) {//
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        // if (left < target) return helper(nums, left + 1, end, target - left + start);
        // if (right > target) return helper(nums, start, right, target);
        if (target + start - 1 >= left) return helper(nums, left, end, target - left + start);
        if (target + start - 1 <= right) return helper(nums, start, right, target);
        return nums[right + 1];
    }
}