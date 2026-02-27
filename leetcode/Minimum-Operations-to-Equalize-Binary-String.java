1import java.util.*;
2
3class Solution {
4    public int minOperations(String s, int k) {
5        int n = s.length();
6        int zeros = 0;
7        for (int i = 0; i < n; i++) {
8            if (s.charAt(i) == '0') zeros++;
9        }
10
11        // Already all ones
12        if (zeros == 0) return 0;
13
14        int[] dist = new int[n + 1];
15        Arrays.fill(dist, -1);
16        dist[zeros] = 0;
17
18        // Two ordered sets for unvisited states with even / odd parity
19        TreeSet<Integer> even = new TreeSet<>();
20        TreeSet<Integer> odd = new TreeSet<>();
21        for (int z = 0; z <= n; z++) {
22            if (z == zeros) continue;
23            if ((z & 1) == 0) even.add(z);
24            else odd.add(z);
25        }
26
27        Queue<Integer> q = new ArrayDeque<>();
28        q.offer(zeros);
29
30        while (!q.isEmpty()) {
31            int z = q.poll();
32            int d = dist[z];
33
34            // From current zeros = z, number of zeros we flip = i
35            // i ∈ [L, R] where:
36            int L = Math.max(0, k - (n - z)); // at least this many zeros to reach k indices
37            int R = Math.min(k, z);          // at most the number of zeros present
38
39            if (L > R) continue;
40
41            // z' = z + k - 2*i, parity constraint: z' ≡ (z + k) mod 2
42            int parity = (z + k) & 1;
43            TreeSet<Integer> set = (parity == 0) ? even : odd;
44
45            // The reachable range of z' is contiguous:
46            int zMin = z + k - 2 * R; // when i = R
47            int zMax = z + k - 2 * L; // when i = L
48
49            // Iterate all unvisited states in [zMin, zMax] with correct parity
50            Integer cur = set.ceiling(zMin);
51            List<Integer> toRemove = new ArrayList<>();
52            while (cur != null && cur <= zMax) {
53                int nz = cur;
54                dist[nz] = d + 1;
55                q.offer(nz);
56                toRemove.add(nz);
57                cur = set.higher(cur);
58            }
59            // Remove them from the unvisited set
60            for (int v : toRemove) {
61                set.remove(v);
62            }
63        }
64
65        return dist[0];
66    }
67}
68