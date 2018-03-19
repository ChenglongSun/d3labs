class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, 0, new ArrayList<>());
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, int pos, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i - 1] == nums[i]) continue;
            temp.add(nums[i]);
            dfs(nums, res, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}