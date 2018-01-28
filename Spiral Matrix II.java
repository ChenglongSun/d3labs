class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) return res;
        int i = 1;
        int rowTop = 0;
        int rowBot = n - 1;
        int colLeft = 0;
        int colRight = n - 1;
        
        while (i <= n * n) {
            for (int j = colLeft; j <= colRight; j++) {
                res[rowTop][j] = i++;
            }
            rowTop++;
            for (int j = rowTop; j <= rowBot; j++) {
                res[j][colRight] = i++;
            }
            colRight--;
            if (rowTop < rowBot || colLeft < colRight) {
                for (int j = colRight; j >= colLeft; j--) {
                    res[rowBot][j] = i++;
                }
                rowBot--;
                for (int j = rowBot; j >= rowTop; j--) {
                    res[j][colLeft] = i++;
                }
                colLeft++;
            }
        }
        return res;
    }
}