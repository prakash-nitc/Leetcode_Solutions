1import java.util.*;
2
3class Solution {
4    public int longestBalanced(int[] nums) {
5        int n = nums.length;
6        int ans = 0;
7
8        // Try every starting index
9        for (int i = 0; i < n; i++) {
10            // Sets for distinct even and odd numbers in the current subarray
11            HashSet<Integer> evens = new HashSet<>();
12            HashSet<Integer> odds = new HashSet<>();
13
14            // Extend the subarray to the right
15            for (int j = i; j < n; j++) {
16                int x = nums[j];
17                if ((x & 1) == 0) {
18                    evens.add(x);
19                } else {
20                    odds.add(x);
21                }
22
23                if (evens.size() == odds.size()) {
24                    ans = Math.max(ans, j - i + 1);
25                }
26            }
27        }
28
29        return ans;
30    }
31}
32