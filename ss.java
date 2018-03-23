class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                temp.add(nums[i]);
                dfs(nums, res, temp, remain - nums[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}