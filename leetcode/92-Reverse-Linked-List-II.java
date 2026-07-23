/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode dummy= new ListNode();
       dummy.next=head;

       ListNode leftPre= dummy;
       ListNode currNode= head;

       for(int i=0; i<left-1; i++)
       {
        leftPre= leftPre.next;
        currNode= currNode.next;
       }

       ListNode sublistHead= currNode;

       ListNode preNode= null;
       for(int i=0; i<right-left+1; i++)
       {
        ListNode temp= currNode.next;
        currNode.next= preNode;
        preNode= currNode;
        currNode= temp;
       }

       leftPre.next= preNode;
       sublistHead.next= currNode;

       return dummy.next;
    }
}