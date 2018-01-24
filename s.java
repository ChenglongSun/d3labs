class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, used, res, list);
        return res;
        
    }
    
    public void dfs(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            dfs(nums, used, res, temp);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}