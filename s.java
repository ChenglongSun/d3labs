class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int i = m - 1, j = n - 1, len = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[len--] = nums1[i--];
            } else {
                nums1[len--] = nums2[j--];
            }
        }
        if (j >= 0) {
            for (; j >= 0; j--) {
                nums1[j] = nums2[j];
            }
        }
    }
}