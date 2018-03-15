class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;
        
        for (int[] edge : edges) {
            int root1 = findRoot(root, edge[0]);
            int root2 = findRoot(root, edge[1]);
            
            if (root1 != root2) {
                root[root1] = root2;
                n--;
            }
        }
        return n;
    }
    
    public int findRoot(int[] root, int id) {
        while (root[id] != id) {
            root[id] = root[root[id]];// 加速
            id = root[id];
        }
        return id;
    }
}