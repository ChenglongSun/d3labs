class Solution {
	public int deleteChar(String s) {
		char[] chars = s.toCharArray();
		int[] dp = new int[26];
		for (char c : chars) {
			int idx = c - 'a';
			int count = 0;
			for (int i = 0; i < idx; i++) {
				count = Math.max(count, dp[i]);
			}
			dp[idx] = count + 1;
		}
		int maxLen = 0;
		for (int num : dp) {
			maxLen = Math.max(maxLen, num);
		}
		return s.length() - maxLen;
	}
}