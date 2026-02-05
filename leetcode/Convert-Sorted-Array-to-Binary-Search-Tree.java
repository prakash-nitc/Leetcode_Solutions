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
18    public TreeNode sortedArrayToBST(int[] nums) {
19        if (nums == null || nums.length == 0) return null;
20        return build(nums, 0, nums.length - 1);
21    }
22
23    private TreeNode build(int[] nums, int left, int right) {
24        if (left > right) return null;
25
26        int mid = left + (right - left) / 2; // avoid overflow
27        TreeNode root = new TreeNode(nums[mid]);
28
29        root.left = build(nums, left, mid - 1);
30        root.right = build(nums, mid + 1, right);
31
32        return root;
33    }
34}
35