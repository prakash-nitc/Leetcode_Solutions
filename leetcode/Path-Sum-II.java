1class Solution {
2    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
3        List<List<Integer>> ans = new ArrayList<>();
4        List<Integer> path = new ArrayList<>();
5        dfs(root, targetSum, path, ans);
6        return ans;
7    }
8
9    private void dfs(TreeNode node, int remaining, List<Integer> path, List<List<Integer>> ans) {
10        if (node == null) return;
11        path.add(node.val);
12        remaining -= node.val;
13        if (node.left == null && node.right == null && remaining == 0) {
14            ans.add(new ArrayList<>(path));
15        }
16        dfs(node.left, remaining, path, ans);
17        dfs(node.right, remaining, path, ans);
18        path.remove(path.size() - 1);
19    }
20}