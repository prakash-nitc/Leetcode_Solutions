1import java.util.*;
2
3class Solution {
4
5    static class MultiSet {
6        TreeMap<Integer, Integer> map = new TreeMap<>();
7        int size = 0;
8
9        void add(int x) {
10            map.put(x, map.getOrDefault(x, 0) + 1);
11            size++;
12        }
13
14        void remove(int x) {
15            int c = map.get(x);
16            if (c == 1) map.remove(x);
17            else map.put(x, c - 1);
18            size--;
19        }
20
21        int firstKey() { return map.firstKey(); }
22        int lastKey()  { return map.lastKey(); }
23        boolean contains(int x) { return map.containsKey(x); }
24    }
25
26    // rebalance so that small has the smallest `need` elements
27    private void rebalance(MultiSet small, MultiSet large, long[] sumSmall, int need) {
28        // small.size must not exceed need
29        while (small.size > need) {
30            int x = small.lastKey();
31            small.remove(x);
32            sumSmall[0] -= x;
33            large.add(x);
34        }
35        // small.size should be as large as possible up to need
36        while (small.size < need && large.size > 0) {
37            int x = large.firstKey();
38            large.remove(x);
39            small.add(x);
40            sumSmall[0] += x;
41        }
42    }
43
44    public long minimumCost(int[] nums, int k, int dist) {
45        int n = nums.length;
46        int need = k - 1;              // how many extra starts we need
47        if (need == 0) return nums[0];
48
49        MultiSet small = new MultiSet();   // k-1 smallest in window
50        MultiSet large = new MultiSet();   // rest
51        long[] sumSmall = new long[1];     // sumSmall[0] = sum of elements in small
52
53        long ans = Long.MAX_VALUE;
54
55        int left = 1;
56        for (int right = 1; right < n; right++) {
57            int val = nums[right];
58
59            if (small.size < need) {
60                small.add(val);
61                sumSmall[0] += val;
62            } else {
63                if (small.size == 0 || val >= small.lastKey()) {
64                    large.add(val);
65                } else {
66                    int big = small.lastKey();
67                    small.remove(big);
68                    sumSmall[0] -= big;
69                    large.add(big);
70
71                    small.add(val);
72                    sumSmall[0] += val;
73                }
74            }
75            rebalance(small, large, sumSmall, need);
76
77            // maintain window length <= dist + 1
78            while (right - left + 1 > dist + 1) {
79                int rem = nums[left];
80                left++;
81                if (small.contains(rem)) {
82                    small.remove(rem);
83                    sumSmall[0] -= rem;
84                } else {
85                    large.remove(rem);
86                }
87                rebalance(small, large, sumSmall, need);
88            }
89
90            if (right >= left && small.size == need) {
91                ans = Math.min(ans, nums[0] + sumSmall[0]);
92            }
93        }
94
95        return ans;
96    }
97}
98