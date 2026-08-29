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
    public void preorder(TreeNode n, List<Integer> out)
    {
        if(n== null)
            return;
        out.add(n.val);
        preorder(n.left, out);
        preorder(n.right, out);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> out= new ArrayList<>();
        
        if(root== null)
            return out;
        preorder(root, out);
        return out;
    }
}