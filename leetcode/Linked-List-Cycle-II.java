1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode detectCycle(ListNode head) {
14        ListNode slow = head;
15        ListNode fast = head;
16
17        while( fast!= null && fast.next!=null)
18        {
19            slow= slow.next;
20            fast=fast.next.next;
21
22            if (slow == fast)
23            {
24                slow= head;
25                while(slow != fast)
26                {
27                    slow= slow.next;
28                    fast= fast.next;
29                }
30                return slow;
31            }
32        }
33       return null;
34    }
35}
36