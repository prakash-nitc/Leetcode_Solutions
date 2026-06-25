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
12    public boolean isPalindrome(ListNode head) {
13        ListNode slow= head;
14        ListNode fast= head;
15        ListNode start= head;
16
17        while(fast!= null && fast.next != null)
18        {
19            slow= slow.next;
20            fast= fast.next.next;
21        }
22
23        ListNode prev= null, curr= slow, next = null;
24        while(curr!=null)
25        {
26            next= curr.next;
27            curr.next= prev;
28            prev= curr;
29            curr = next;
30        }
31        while(start!= null && prev!=null)
32        {
33            if(start.val==prev.val)
34            {    
35                start= start.next;
36                prev= prev.next;
37            }
38            else 
39                return false;
40        }
41        return true;
42    }
43}