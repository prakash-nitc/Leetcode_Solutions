1class Solution {
2    public ListNode reverseBetween(ListNode head, int left, int right) {
3        if (head == null || left == right) return head;
4        ListNode dummy = new ListNode(0);
5        dummy.next = head;
6        ListNode prev = dummy;
7        for (int i = 1; i < left; i++) {
8            prev = prev.next;
9        }
10        ListNode curr = prev.next;
11        for (int i = 0; i < right - left; i++) {
12            ListNode temp = curr.next;
13            curr.next = temp.next;
14            temp.next = prev.next;
15            prev.next = temp;
16        }
17        return dummy.next;
18    }
19}