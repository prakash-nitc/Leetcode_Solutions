1import java.util.*;
2
3class Solution {
4
5    static class DSU {
6        int[] parent;
7        int[] rank;
8        int components;
9
10        DSU(int n) {
11            parent = new int[n];
12            rank = new int[n];
13            components = n;
14            for (int i = 0; i < n; i++) parent[i] = i;
15        }
16
17        int find(int x) {
18            if (parent[x] != x) parent[x] = find(parent[x]);
19            return parent[x];
20        }
21
22        boolean union(int a, int b) {
23            int ra = find(a), rb = find(b);
24            if (ra == rb) return false;
25            if (rank[ra] < rank[rb]) {
26                parent[ra] = rb;
27            } else if (rank[ra] > rank[rb]) {
28                parent[rb] = ra;
29            } else {
30                parent[rb] = ra;
31                rank[ra]++;
32            }
33            components--;
34            return true;
35        }
36    }
37
38    public int maxStability(int n, int[][] edges, int k) {
39        int maxS = 0;
40        for (int[] e : edges) maxS = Math.max(maxS, e[2]);
41
42        int lo = 0, hi = maxS * 2;
43        int ans = -1;
44
45        while (lo <= hi) {
46            int mid = lo + (hi - lo) / 2;
47            if (can(mid, n, edges, k)) {
48                ans = mid;
49                lo = mid + 1;
50            } else {
51                hi = mid - 1;
52            }
53        }
54        return ans;
55    }
56
57    private boolean can(int target, int n, int[][] edges, int k) {
58        DSU dsu = new DSU(n);
59
60        // 1) add mandatory edges, they cannot be upgraded
61        for (int[] e : edges) {
62            int u = e[0], v = e[1], s = e[2], must = e[3];
63            if (must == 1) {
64                if (s < target) return false;          // mandatory too weak
65                if (!dsu.union(u, v)) return false;    // mandatory cycle
66            }
67        }
68
69        // 2) sort optional edges by strength descending
70        List<int[]> opt = new ArrayList<>();
71        for (int[] e : edges) if (e[3] == 0) opt.add(e);
72        opt.sort((a, b) -> Integer.compare(b[2], a[2]));
73
74        long used = 0;
75
76        for (int[] e : opt) {
77            if (dsu.components == 1) break;
78
79            int u = e[0], v = e[1], s = e[2];
80            int ru = dsu.find(u), rv = dsu.find(v);
81            if (ru == rv) continue;
82
83            if (s >= target) {
84                // strong enough without upgrade
85                dsu.union(ru, rv);
86            } else if (s * 2 >= target && used < k) {
87                // use upgrade to meet target
88                used++;
89                dsu.union(ru, rv);
90            }
91            // otherwise cannot help for this target
92        }
93
94        return dsu.components == 1 && used <= k;
95    }
96}
97