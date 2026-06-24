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
11import java.util.*;
12
13class Solution {
14    public ListNode reverseList(ListNode head) {
15        ListNode prev = null, temp= head, next=null;
16
17        while(temp!=null)
18        {
19            next= temp.next;
20            temp.next= prev;
21            prev= temp;
22            temp= next;
23        }
24        return prev;
25    }
26}
27