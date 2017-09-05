public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len = nums1.length + nums2.length;
        
        if (len % 2 == 1) {
            return find(nums1, 0, nums2, 0, len/2 + 1);
        } else {
        return ( find(nums1, 0, nums2, 0, len / 2) + find(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;//???2.00000
        }
    }
    private static int find(int[] nums1, int p, int[] nums2, int q, int k) {
        if (p >= nums1.length) {
            return nums2[q + k - 1];
        }
        if (q >= nums2.length) {
            return nums1[p + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[p], nums2[q]);
        }
        
        int a = p + k / 2 - 1 < nums1.length? nums1[p + k / 2 - 1] : Integer.MAX_VALUE;//！！！
        int b = q + k / 2 - 1 < nums2.length? nums2[q + k / 2 - 1] : Integer.MAX_VALUE;
        if (a < b) {
            return find(nums1, p + k / 2, nums2, q, k - k / 2);
        } else {
            return find(nums1, p, nums2, q + k / 2, k - k / 2);
        }
    }
}