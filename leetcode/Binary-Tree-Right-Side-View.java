1class Solution {
2    public List<Integer> rightSideView(TreeNode root) {
3        List<Integer> result = new ArrayList<>();
4        if (root == null) {
5            return result;
6        }
7        Queue<TreeNode> queue = new LinkedList<>();
8        queue.offer(root);
9        while (!queue.isEmpty()) {
10            int levelSize = queue.size();
11            for (int i = 0; i < levelSize; i++) {
12                TreeNode node = queue.poll();
13                if (i == levelSize - 1) {
14                    result.add(node.val);
15                }
16                if (node.left != null) {
17                    queue.offer(node.left);
18                }
19                if (node.right != null) {
20                    queue.offer(node.right);
21                }
22            }
23        }
24        return result;
25    }
26}