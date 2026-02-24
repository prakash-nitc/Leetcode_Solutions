1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16
17class Solution {
18    public int sumRootToLeaf(TreeNode root) {
19        return dfs(root, 0);
20    }
21
22    private int dfs(TreeNode node, int curr) {
23        if (node == null) return 0;
24
25        // shift left (multiply by 2) and add current bit
26        curr = (curr << 1) | node.val;
27
28        // if leaf, this path contributes fully
29        if (node.left == null && node.right == null) {
30            return curr;
31        }
32
33        // sum from left and right subtrees
34        return dfs(node.left, curr) + dfs(node.right, curr);
35    }
36}
37