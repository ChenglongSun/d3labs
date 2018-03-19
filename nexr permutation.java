class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        int idx = len - 1;
        while (idx > 0) {
            if (nums[idx - 1] < nums[idx]) break;
            idx--;
        }
        
        if (idx == 0) {
            reverse(nums, 0, len - 1);
            return;
        } else {
            int val = nums[idx - 1];
            int j = len - 1;
            while (len >= idx) {
                if (nums[j] > val) break;
                j--;
            }
            swap(nums, idx - 1, j);
            reverse(nums, idx, len - 1);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}