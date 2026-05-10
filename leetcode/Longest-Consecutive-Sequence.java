1import java.util.*;
2
3class Solution {
4    public int longestConsecutive(int[] nums) {
5        if (nums == null || nums.length == 0) return 0;
6
7        Set<Integer> set = new HashSet<>();
8        for (int num : nums) set.add(num);
9
10        int longest = 0;
11
12        for (int num : set) {
13            if (!set.contains(num - 1)) {
14                int curr = num;
15                int length = 1;
16                while (set.contains(curr + 1)) {
17                    curr++;
18                    length++;
19                }
20                longest = Math.max(longest, length);
21            }
22        }
23
24        return longest;
25    }
26}