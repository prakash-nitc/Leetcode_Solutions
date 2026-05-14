1class Solution {
2    public List<Integer> rightSideView(TreeNode root) {
3        List<Integer> result = new ArrayList<>();
4        dfs(root, 0, result);
5        return result;
6    }
7    
8    private void dfs(TreeNode node, int level, List<Integer> result) {
9        if (node == null) {
10            return;
11        }
12        if (level == result.size()) {
13            result.add(node.val);
14        }
15        dfs(node.right, level + 1, result);
16        dfs(node.left, level + 1, result);
17    }
18}