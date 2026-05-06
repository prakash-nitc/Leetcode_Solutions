1class Solution {
2    public Node connect(Node root) {
3        if (root == null) return root;
4        Node leftmost = root;
5        while (leftmost.left != null) {
6            Node head = leftmost;
7            while (head != null) {
8                head.left.next = head.right;
9                if (head.next != null) {
10                    head.right.next = head.next.left;
11                }
12                head = head.next;
13            }
14            leftmost = leftmost.left;
15        }
16        return root;
17    }
18}