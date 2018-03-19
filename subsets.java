class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        
        if (nums == null || nums.length == 0) return res;
        
        
        dfs(nums, res, new ArrayList<Integer>(), 0);
        return res;
        
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            dfs(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    
}