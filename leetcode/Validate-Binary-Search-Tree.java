1class Solution {
2    public boolean isValidBST(TreeNode root) {
3        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
4    }
5
6    private boolean helper(TreeNode node, long low, long high) {
7        if (node == null) return true;
8
9        if (node.val <= low || node.val >= high) return false;
10
11        return helper(node.left, low, node.val) &&
12               helper(node.right, node.val, high);
13    }
14}
15