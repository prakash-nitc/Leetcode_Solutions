1class Solution {
2    public ListNode rotateRight(ListNode head, int k) {
3        if (head == null || head.next == null) return head;
4        
5        // Step 1: Find length and tail
6        int length = 1;
7        ListNode tail = head;
8        while (tail.next != null) {
9            tail = tail.next;
10            length++;
11        }
12        
13        // Step 2: Normalize k FIRST, before making circular
14        k = k % length;
15        if (k == 0) return head;  // No rotation needed
16        
17        // Step 3: Make circular
18        tail.next = head;
19        
20        // Step 4: Find new tail (length - k - 1 steps from head)
21        ListNode newTail = head;
22        for (int i = 0; i < length - k - 1; i++) {
23            newTail = newTail.next;
24        }
25        
26        // Step 5: Break circle
27        ListNode newHead = newTail.next;
28        newTail.next = null;
29        return newHead;
30    }
31}
32