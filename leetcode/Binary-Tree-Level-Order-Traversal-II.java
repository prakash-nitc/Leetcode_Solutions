1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> levelOrderBottom(TreeNode root) {
5        List<List<Integer>> res = new ArrayList<>();
6        if (root == null) return res;
7
8        Queue<TreeNode> q = new LinkedList<>();
9        q.offer(root);
10
11        while (!q.isEmpty()) {
12            int size = q.size();
13            List<Integer> level = new ArrayList<>(size);
14            for (int i = 0; i < size; i++) {
15                TreeNode node = q.poll();
16                level.add(node.val);
17                if (node.left != null) q.offer(node.left);
18                if (node.right != null) q.offer(node.right);
19            }
20            res.add(level);
21        }
22
23        Collections.reverse(res);
24        return res;
25    }
26}