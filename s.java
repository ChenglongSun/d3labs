class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            sum[i] += nums[i];
        }        
    }
    
    public int sumRange(int i, int j) {
        return nums[j + 1] - nums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */