1class Solution {
2    public ListNode swapPairs(ListNode head) {
3        // Step 1: Store nodes in a list
4        List<ListNode> nodes = new ArrayList<>();
5        ListNode curr = head;
6        while (curr != null) {
7            nodes.add(curr);
8            curr = curr.next;
9        }
10        // Step 2: Swap values in pairs
11        for (int i = 0; i + 1 < nodes.size(); i += 2) {
12            int temp = nodes.get(i).val;
13            nodes.get(i).val = nodes.get(i + 1).val;
14            nodes.get(i + 1).val = temp;
15        }
16        // Step 3: Return head (list is modified)
17        return head;
18    }
19}
20