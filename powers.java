package com.test1;
import java.util.*;


public class Solution {
	public static void main(String[] args) {
        int nums[] = {1,2,3,2,2,5};
        
        int res = subst(nums);
        System.out.println(res);
    }
	
	public static int subst(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int sum = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int key = sum % 3;
			sum = key;
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		for (int i : map.keySet()) {
			int times = map.get(i) - 1;
			if (times > 0) {
				if (times == 1) {
					count += 1;
				} else {
					count += Math.pow(2, times) - 1;
				}
			}
		}
		return count;
	}
}
