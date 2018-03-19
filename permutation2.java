class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, res, used, new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> temp) {
        if (temp.size() == nums.length) res.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            dfs(nums, res, used, temp);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}