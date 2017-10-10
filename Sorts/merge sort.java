public class Mergesort {
	public static void main(String[] args) {
        int nums[] = {12, 11, 13, 5, 6, 7};
        sort(nums, 0, nums.length - 1);
        System.out.println("\nSorted array:");
        for (int i : nums){
        	System.out.println(i);
        }
    }
	
	public static void merge(int[] nums, int l, int mid, int r) {
		//int mid = (r - l) / 2;
		int n1 = mid - l + 1;
		int n2 = r - mid;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for (int i = 0; i < n1; ++i) {
			left[i] = nums[l + i];
		}
		for (int i = 0; i < n2; ++i) {
			right[i] = nums[mid + i + 1];
		}
		//merge
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]){
				nums[k] = left[i];
				i++;
			} else {
				nums[k] = right[j];
				j++;
			}
			k++;
		}
		if (i < n1) {
			while (i < n1) nums[k++] = left[i++];
		}
		if (j < n2) {
			while (j < n2) nums[k++] = right[j++];
		}
	}
	public static void sort(int[] nums, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(nums, l, m);
			sort(nums, m+1, r);
			merge(nums, l, m, r);
		}
		
	}
}