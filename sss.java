class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (helper(nums1, nums2, 0, 0, l) + helper(nums1, nums2, 0, 0, r)) / 2.0;
    }
    public double helper(int[] nums1, int[] nums2, int i, int j, int k) {
        if (i > nums1.length - 1) return nums2[j + k - 1];
        if (j > nums2.length - 1) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        
        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (i + k/2 - 1 < nums1.length) mid1 = nums1[i + k/2 - 1];
        if (j + k/2 - 1 < nums2.length) mid2 = nums2[j + k/2 - 1];
        
        if (mid1 < mid2) {
            return helper(nums1, nums2, i + k/2, j, k - k/2);
        } else {
            return helper(nums1, nums2, i, j + k/2, k - k/2);
        }
    }
}