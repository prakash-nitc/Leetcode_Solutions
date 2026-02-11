1import java.util.*;
2
3class Solution {
4
5    // Lazy segment tree: supports range add and
6    // query for the rightmost index in [ql, qr] whose value == 0.
7    static class SegTree {
8        int n;
9        int[] mn, mx, lazy;
10
11        SegTree(int n) {
12            this.n = n;
13            mn = new int[4 * n];
14            mx = new int[4 * n];
15            lazy = new int[4 * n];
16        }
17
18        void apply(int idx, int val) {
19            mn[idx] += val;
20            mx[idx] += val;
21            lazy[idx] += val;
22        }
23
24        void push(int idx) {
25            if (lazy[idx] != 0) {
26                apply(idx * 2, lazy[idx]);
27                apply(idx * 2 + 1, lazy[idx]);
28                lazy[idx] = 0;
29            }
30        }
31
32        void rangeAdd(int idx, int l, int r, int ql, int qr, int val) {
33            if (ql > r || qr < l) return;
34            if (ql <= l && r <= qr) {
35                apply(idx, val);
36                return;
37            }
38            push(idx);
39            int m = (l + r) >>> 1;
40            rangeAdd(idx * 2, l, m, ql, qr, val);
41            rangeAdd(idx * 2 + 1, m + 1, r, ql, qr, val);
42            mn[idx] = Math.min(mn[idx * 2], mn[idx * 2 + 1]);
43            mx[idx] = Math.max(mx[idx * 2], mx[idx * 2 + 1]);
44        }
45
46        // rightmost index in [ql, qr] whose value == 0, or -1
47        int lastZero(int idx, int l, int r, int ql, int qr) {
48            if (ql > r || qr < l) return -1;
49            if (mn[idx] > 0 || mx[idx] < 0) return -1; // no zero here
50            if (l == r) return l;
51            push(idx);
52            int m = (l + r) >>> 1;
53            int res = lastZero(idx * 2 + 1, m + 1, r, ql, qr);
54            if (res != -1) return res;
55            return lastZero(idx * 2, l, m, ql, qr);
56        }
57    }
58
59    public int longestBalanced(int[] nums) {
60        int n = nums.length;
61        int maxVal = 100000;
62
63        // positions of each value
64        ArrayList<Integer>[] pos = new ArrayList[maxVal + 1];
65        for (int i = 0; i <= maxVal; i++) pos[i] = new ArrayList<>();
66
67        for (int i = 0; i < n; i++) {
68            pos[nums[i]].add(i);
69        }
70
71        SegTree st = new SegTree(n);
72
73        // For each value, add its first occurrence contribution
74        for (int v = 1; v <= maxVal; v++) {
75            if (pos[v].isEmpty()) continue;
76            int first = pos[v].get(0);
77            int sign = (v & 1) == 1 ? 1 : -1;   // odd +1, even -1
78            st.rangeAdd(1, 0, n - 1, first, n - 1, sign);
79        }
80
81        int[] ptr = new int[maxVal + 1];        // pointer to current "first" in window
82        int ans = 0;
83
84        // left endpoint of window
85        for (int left = 0; left < n; left++) {
86            // best right endpoint for this left
87            int right = st.lastZero(1, 0, n - 1, left, n - 1);
88            if (right != -1) {
89                ans = Math.max(ans, right - left + 1);
90            }
91
92            int v = nums[left];
93            int sign = (v & 1) == 1 ? 1 : -1;
94
95            // remove contribution of current first occurrence of v
96            int curFirst = pos[v].get(ptr[v]);
97            st.rangeAdd(1, 0, n - 1, curFirst, n - 1, -sign);
98
99            // move pointer; if v still appears in window, add contribution from next occurrence
100            ptr[v]++;
101            if (ptr[v] < pos[v].size()) {
102                int nextFirst = pos[v].get(ptr[v]);
103                st.rangeAdd(1, 0, n - 1, nextFirst, n - 1, sign);
104            }
105        }
106
107        return ans;
108    }
109}
110