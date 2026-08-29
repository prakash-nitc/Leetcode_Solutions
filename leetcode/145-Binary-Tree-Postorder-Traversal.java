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
    public void postorder(TreeNode n, List<Integer> out)
    {
        if(n== null)
            return;
        
        postorder(n.left, out);
        postorder(n.right, out);
        out.add(n.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> out= new ArrayList<>();
        
        if(root== null)
            return out;
        postorder(root, out);
        return out;
    }
}