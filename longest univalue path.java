class Solution {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root != null) dfs(root);
        return res;
    }
    
    private int dfs(TreeNode node) {
        int l = node.left != null ? dfs(node.left) : 0; // Longest-Univalue-Path-Start-At - left child
        int r = node.right != null ? dfs(node.right) : 0; // Longest-Univalue-Path-Start-At - right child
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0; 
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0; 
        res = Math.max(res, resl + resr); // Longest-Univalue-Path-Across - node
        return Math.max(resl, resr);
    }
}