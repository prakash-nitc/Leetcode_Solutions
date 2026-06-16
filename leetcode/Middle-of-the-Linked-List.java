1class Solution {
2    public ListNode middleNode(ListNode head) {
3        ListNode slow = head;
4        ListNode fast = head;
5
6        // fast moves 2 steps, slow moves 1 step
7        while (fast != null && fast.next != null) {
8            slow = slow.next;
9            fast = fast.next.next;
10        }
11
12        // slow is now at the middle (second middle if even length)
13        return slow;
14    }
15}
16