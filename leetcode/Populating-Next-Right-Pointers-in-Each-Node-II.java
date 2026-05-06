1class Solution {
2    public Node connect(Node root) {
3        if (root == null) return null;
4        Node curr = root;
5        while (curr != null) {
6            Node dummy = new Node(0);
7            Node tail = dummy;
8            while (curr != null) {
9                if (curr.left != null) {
10                    tail.next = curr.left;
11                    tail = tail.next;
12                }
13                if (curr.right != null) {
14                    tail.next = curr.right;
15                    tail = tail.next;
16                }
17                curr = curr.next;
18            }
19            curr = dummy.next;
20        }
21        return root;
22    }
23}