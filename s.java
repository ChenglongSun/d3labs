class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new ArrayList<Integer>());
        return res;
    }
    public void helper(TreeNode root, int target, List<List<Integer>> res, List<Integer> temp) {
        if (root == null) return;
        temp.add(new Integer(root.val));
        if (root.left == null && root.right == null && root.val == target) {
            res.add(new ArrayList(temp));
            temp.remove(temp.size() - 1);
            return;
        } else {
            helper(root.left, target - root.val, res, temp);
            helper(root.right, target - root.val, res, temp);
        }
        temp.remove(temp.size() - 1);
    }
}