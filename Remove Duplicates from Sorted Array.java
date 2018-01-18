class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) nums[res++] = nums[i];
        }
        return res;
    }
}