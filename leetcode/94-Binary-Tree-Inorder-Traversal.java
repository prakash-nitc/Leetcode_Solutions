/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorder(TreeNode n, List<Integer> out)
    {
        if(n== null)
            return;
        inorder(n.left, out);
        out.add(n.val);
        inorder(n.right, out);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out= new ArrayList<>();
        
        if(root== null)
            return out;
        inorder(root, out);
        return out;
    }
}