public class Quicksort {
	public static void main(String args[]) {
		int[] nums = {10, 7, 8, 9, 1, 5};
		sort(nums, 0, nums.length - 1);
		for (int i : nums) {
			System.out.println(i);
		}
	}
	public static void sort(int[] nums, int l, int r){
		if (l < r){
			int m = partition(nums, l, r);
			sort(nums, l, m - 1);//
			sort(nums, m + 1, r);
		}
	}
	
	public static int partition(int[] nums, int l, int r) {
		int pivot = nums[r];
		int k = l;
		for (int i = l; i < r; i++) {
			if (nums[i] <= pivot) {
				swap(nums, k, i);
				k++;
			}
		}
		swap(nums,k, r);
		return k;
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
