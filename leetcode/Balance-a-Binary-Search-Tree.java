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
16class Solution {
17
18    public TreeNode balanceBST(TreeNode root) {
19        List<Integer> inorderList = new ArrayList<>();
20        inorder(root, inorderList);                  // step 1: get sorted values
21        return buildBalanced(inorderList, 0, inorderList.size() - 1); // step 2: build balanced BST
22    }
23
24    private void inorder(TreeNode node, List<Integer> list) {
25        if (node == null) return;
26        inorder(node.left, list);
27        list.add(node.val);
28        inorder(node.right, list);
29    }
30
31    private TreeNode buildBalanced(List<Integer> nums, int lo, int hi) {
32        if (lo > hi) return null;
33        int mid = lo + (hi - lo) / 2;
34        TreeNode root = new TreeNode(nums.get(mid));
35        root.left = buildBalanced(nums, lo, mid - 1);
36        root.right = buildBalanced(nums, mid + 1, hi);
37        return root;
38    }
39}
40