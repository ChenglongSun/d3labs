class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max((i - j), dp[i - j]));
            }
        }
        return dp[n];
    }
}