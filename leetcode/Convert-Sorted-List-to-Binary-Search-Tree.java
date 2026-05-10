1class Solution {
2    private ListNode curr;
3
4    public TreeNode sortedListToBST(ListNode head) {
5        int size = 0;
6        curr = head;
7        while (head != null) {
8            size++;
9            head = head.next;
10        }
11        return buildBST(0, size - 1);
12    }
13
14    private TreeNode buildBST(int left, int right) {
15        if (left > right) return null;
16        int mid = left + (right - left) / 2;
17        TreeNode l = buildBST(left, mid - 1);
18        TreeNode root = new TreeNode(curr.val);
19        curr = curr.next;
20        TreeNode r = buildBST(mid + 1, right);
21        root.left = l;
22        root.right = r;
23        return root;
24    }
25}