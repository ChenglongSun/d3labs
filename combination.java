class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0) return res;
        dfs(n, k, res, new ArrayList<>(), 1);
        return res;
    }
    
    public void dfs(int n, int k, List<List<Integer>> res, List<Integer> temp, int i) {
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
        } else {
            for (int j = i; j <= n; j++) {
                temp.add(j);
                dfs(n, k, res, temp, j + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}