class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;//city number
        int m = days[0].length;//weeks number
        int[][] dp = new int[n][m];
        //initial the dp matrix
        for (int i = 0; i < dp.length; i++) {
            dp[i][m - 1] = days[i][m - 1];
        }
        
        for (int i = m - 2; i >= 0; i--) {//列
            for (int j = 0; j < n; j++) {//行
                for (int k = 0; k < n; k++) { 
                    if (flights[j][k] == 1 || j == k) {
                        dp[j][i] = Math.max(dp[j][i], days[j][i] + dp[k][i + 1]);
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (flights[0][j] == 1 || j == 0) {
                ans = Math.max(ans, dp[j][0]);
            }
        }
        return ans;
    }
}