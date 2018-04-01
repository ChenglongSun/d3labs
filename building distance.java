class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        int[][] nums = new int[m][n]; //to record: for each available spot how many building can it reach
        int count = 0; //to find out how many buildings in total
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
               if(grid[i][j] == 1) {
                   bfs(grid, i, j, m, n, count++, nums);
               }
            }
        }
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] < 0 && nums[i][j] == count) {
                    min = Math.max(min, grid[i][j]); //distance is negative. 
                }
            }
        }
        return min != Integer.MIN_VALUE? -min: -1;
    }
    
    public void bfs(int[][] grid, int x0, int y0, int m, int n, int count, int[][] nums) {
        boolean[][] visited = new boolean[m][n];
        visited[x0][y0] = true;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x0, y0});
        int step = -1; //distance is represented in negative number.
        while(!queue.isEmpty()) {
           int levelNum = queue.size();
            for(int i = 0; i < levelNum; i++) {
                int[] cur = queue.poll();
                for(int[] dir: dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || grid[x][y] > 0) { 
                        continue; //grid[x][y] > 0 means this is either an obstacle or a building
                    }
                    if(grid[x][y] == 0 && nums[x][y] < count) { //meaning that there must be at least one building that this spot can't reach
                        continue;
                    }
                    visited[x][y] = true;
                    nums[x][y]++;
                    grid[x][y] += step;
                    queue.offer(new int[]{x, y});
                }
            }
            step--;
        }
    }
    
}