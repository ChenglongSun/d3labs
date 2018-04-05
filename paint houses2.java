class Solution {
    public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0) return 0;
        
    int n = costs.length, k = costs[0].length;
    // min1 is the index of the 1st-smallest cost till previous house
    // min2 is the index of the 2nd-smallest cost till previous house
    int min1 = -1, min2 = -1;
    
    for (int i = 0; i < n; i++) {
        int last1 = min1, last2 = min2;
        min1 = -1; min2 = -1;
        
        for (int j = 0; j < k; j++) {
            if (j != last1) {
                // current color j is different to last min1 不同于上一次最小的，那么就直接加上一次最小结果
                costs[i][j] += (last1 < 0) ? 0 : costs[i - 1][last1];
            } else {//与上一次最小相同index，那么就选第二小的加
                costs[i][j] += (last2 < 0) ? 0 : costs[i - 1][last2];
            }
            
            // find the indices of 1st and 2nd smallest cost of painting current house i
            //每一次处理完costs[i][j]都检查更新一遍min1 min2！！！
            if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                min2 = min1; 
                min1 = j;
            } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                min2 = j;
            }
        }
    }
    
    return costs[n - 1][min1];
}
}