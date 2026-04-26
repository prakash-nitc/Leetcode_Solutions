1import java.util.*;
2
3class Solution {
4    public long[] distance(int[] nums) {
5        int n = nums.length;
6        long[] ans = new long[n];
7
8        // Map each value to the list of indices where it appears
9        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
10        for (int i = 0; i < n; i++) {
11            valueToIndices
12                .computeIfAbsent(nums[i], k -> new ArrayList<>())
13                .add(i);
14        }
15
16        // For each group of equal values, compute distances
17        for (List<Integer> indices : valueToIndices.values()) {
18            int m = indices.size();
19            if (m == 1) {
20                // Only one occurrence => distances are 0 for that index
21                ans[indices.get(0)] = 0L;
22                continue;
23            }
24
25            // Compute total sum of indices for this value
26            long totalSum = 0L;
27            for (int idx : indices) {
28                totalSum += idx;
29            }
30
31            long prefixSum = 0L; // sum of indices to the left (including current when we update)
32            for (int i = 0; i < m; i++) {
33                int idx = indices.get(i);
34
35                // Left side: i elements on the left (indices[0..i-1])
36                long leftCount = i;
37                long rightCount = m - i - 1L;
38
39                // Sum of indices on the right: totalSum - prefixSum - idx
40                long leftContribution = (long) idx * leftCount - prefixSum;
41                long rightContribution = (totalSum - prefixSum - idx) - (long) idx * rightCount;
42
43                ans[idx] = leftContribution + rightContribution;
44
45                prefixSum += idx;
46            }
47        }
48
49        return ans;
50    }
51}