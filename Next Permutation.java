class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        //逆序找第一个递增的元素
        int index = n - 1;
        while (index > 0) {
            if (nums[index - 1] < nums[index]) break;
            index--;
        }
        //逆序找第一个比index大的元素与之交换，并且全局反转
        if (index == 0) {
            reverseSort(nums, 0, n - 1);
            return;
        } else {
            int val = nums[index - 1];
            int j = n - 1;
            while (j >= index) {
                if (nums[j] > val) break;
                j--;
            }
            swap(nums, j, index - 1);
            reverseSort(nums, index, n - 1);
            return;
        }
    }
    //定义swap
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //定义全局反转
    public void reverseSort(int[] nums, int start, int end) {
        if (start > end) return;
        for (int i = start; i <= (end + start) / 2; i++){
            swap(nums, i, start + end - i);
        }
    }
}