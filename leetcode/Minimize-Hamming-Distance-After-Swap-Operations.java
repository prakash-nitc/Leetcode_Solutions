1import java.util.*;
2
3class Solution {
4    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
5        int n = source.length;
6        UnionFind uf = new UnionFind(n);
7
8        // Build connected components using allowed swaps
9        for (int[] e : allowedSwaps) {
10            uf.union(e[0], e[1]);
11        }
12
13        // root -> (value -> frequency in source for this component)
14        Map<Integer, Map<Integer, Integer>> compFreq = new HashMap<>();
15
16        for (int i = 0; i < n; i++) {
17            int root = uf.find(i);
18            compFreq
19                .computeIfAbsent(root, k -> new HashMap<>())
20                .merge(source[i], 1, Integer::sum);
21        }
22
23        int ans = 0;
24
25        // For each index, try to match target[i] using the component's multiset
26        for (int i = 0; i < n; i++) {
27            int root = uf.find(i);
28            Map<Integer, Integer> freq = compFreq.get(root);
29
30            // Decrease count for target[i]; if it goes negative, it's a mismatch
31            freq.merge(target[i], -1, Integer::sum);
32            if (freq.get(target[i]) < 0) {
33                ans++;
34            }
35        }
36
37        return ans;
38    }
39
40    // Standard Union-Find with path compression
41    static class UnionFind {
42        int[] parent;
43        int[] rank;
44
45        UnionFind(int n) {
46            parent = new int[n];
47            rank = new int[n];
48            for (int i = 0; i < n; i++) {
49                parent[i] = i;
50                rank[i] = 0;
51            }
52        }
53
54        int find(int x) {
55            if (parent[x] != x) {
56                parent[x] = find(parent[x]);
57            }
58            return parent[x];
59        }
60
61        void union(int x, int y) {
62            int rx = find(x);
63            int ry = find(y);
64            if (rx == ry) return;
65
66            if (rank[rx] < rank[ry]) {
67                parent[rx] = ry;
68            } else if (rank[rx] > rank[ry]) {
69                parent[ry] = rx;
70            } else {
71                parent[ry] = rx;
72                rank[rx]++;
73            }
74        }
75    }
76}