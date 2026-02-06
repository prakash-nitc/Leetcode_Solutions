1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode partition(ListNode head, int x) {
13        // Dummy heads for the two partitions
14        ListNode smallerDummy = new ListNode(0);
15        ListNode greaterDummy = new ListNode(0);
16
17        ListNode smaller = smallerDummy;
18        ListNode greater = greaterDummy;
19
20        ListNode curr = head;
21        while (curr != null) {
22            if (curr.val < x) {
23                smaller.next = curr;
24                smaller = smaller.next;
25            } else {
26                greater.next = curr;
27                greater = greater.next;
28            }
29            curr = curr.next;
30        }
31
32        // Important: end the greater list
33        greater.next = null;
34        // Connect smaller list to greater list
35        smaller.next = greaterDummy.next;
36
37        return smallerDummy.next;
38    }
39}
40