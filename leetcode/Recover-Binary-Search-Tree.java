1class Solution {
2    private TreeNode first;
3    private TreeNode second;
4    private TreeNode prev;
5
6    public void recoverTree(TreeNode root) {
7        TreeNode curr = root;
8        TreeNode pred;
9
10        while (curr != null) {
11            if (curr.left == null) {
12                detect(curr);
13                curr = curr.right;
14            } else {
15                pred = curr.left;
16                while (pred.right != null && pred.right != curr) {
17                    pred = pred.right;
18                }
19                if (pred.right == null) {
20                    pred.right = curr;
21                    curr = curr.left;
22                } else {
23                    pred.right = null;
24                    detect(curr);
25                    curr = curr.right;
26                }
27            }
28        }
29
30        int tmp = first.val;
31        first.val = second.val;
32        second.val = tmp;
33    }
34
35    private void detect(TreeNode node) {
36        if (prev != null && prev.val > node.val) {
37            if (first == null) {
38                first = prev;
39            }
40            second = node;
41        }
42        prev = node;
43    }
44}