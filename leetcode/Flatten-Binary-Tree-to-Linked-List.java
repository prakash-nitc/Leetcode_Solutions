1class Solution {
2    public void flatten(TreeNode root) {
3        TreeNode curr = root;
4        while (curr != null) {
5            if (curr.left != null) {
6                TreeNode prev = curr.left;
7                while (prev.right != null) {
8                    prev = prev.right;
9                }
10                prev.right = curr.right;
11                curr.right = curr.left;
12                curr.left = null;
13            }
14            curr = curr.right;
15        }
16    }
17}