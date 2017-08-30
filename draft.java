public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int j = 1; j < n; j++) {
            if(pattern[j] == '*') {
                dp[0][j + 1] = dp[0][j - 1];
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pattern[j] == '.' || pattern[j] == text[i]) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if(pattern[j] == '*') {
                    //match 0 preceding element
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    //match more than 0 preceding element
                    if(pattern[j - 1] == text[i] || pattern[j - 1] == '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j + 1] | dp[i][j + 1];
                    } 
                }
            }
        }
        
        return dp[m][n];
    }
}