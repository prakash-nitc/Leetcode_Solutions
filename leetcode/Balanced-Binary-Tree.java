1class Solution {
2    public boolean isBalanced(TreeNode root) {
3        if (root == null) return true;
4        int leftHeight = getHeight(root.left);
5        int rightHeight = getHeight(root.right);
6        if (Math.abs(leftHeight - rightHeight) > 1) return false;
7        // Recursively check left and right subtrees
8        return isBalanced(root.left) && isBalanced(root.right);
9    }
10    
11    // Helper function to compute height
12    private int getHeight(TreeNode node) {
13        if (node == null) return 0;
14        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
15    }
16}
17