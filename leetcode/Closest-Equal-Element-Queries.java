1import java.util.*;
2
3class Solution {
4    public List<Integer> solveQueries(int[] nums, int[] queries) {
5        int n = nums.length;
6        int m = n * 2;
7
8        int[] minDistances = new int[m];
9        Arrays.fill(minDistances, m);
10
11        Map<Integer, Integer> lastPos = new HashMap<>();
12        for (int i = 0; i < m; i++) {
13            int val = nums[i % n];
14            if (lastPos.containsKey(val)) {
15                int dist = i - lastPos.get(val);
16                minDistances[i] = Math.min(minDistances[i], dist);
17            }
18            lastPos.put(val, i);
19        }
20
21        Map<Integer, Integer> nextPos = new HashMap<>();
22        for (int i = m - 1; i >= 0; i--) {
23            int val = nums[i % n];
24            if (nextPos.containsKey(val)) {
25                int dist = nextPos.get(val) - i;
26                minDistances[i] = Math.min(minDistances[i], dist);
27            }
28            nextPos.put(val, i);
29        }
30
31        for (int i = 0; i < n; i++) {
32            minDistances[i] = Math.min(minDistances[i], minDistances[i + n]);
33        }
34
35        List<Integer> ans = new ArrayList<>();
36        for (int idx : queries) {
37            int d = minDistances[idx];
38            ans.add(d >= n ? -1 : d);
39        }
40
41        return ans;
42    }
43}