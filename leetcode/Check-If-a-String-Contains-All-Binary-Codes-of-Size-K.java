1class Solution {
2    public boolean hasAllCodes(String s, int k) {
3        int n = s.length();
4        // Total distinct binary codes of length k
5        int need = 1 << k;
6        if (n < need + k - 1) {
7            // Quick pruning: not enough length to contain all codes
8            return false;
9        }
10
11        boolean[] seen = new boolean[need];
12        int mask = need - 1;   // will keep only k bits
13        int cur = 0;           // current k-bit value
14        int count = 0;         // how many distinct codes we've seen
15
16        for (int i = 0; i < n; i++) {
17            // Shift left, add current bit, and keep only last k bits
18            cur = ((cur << 1) & mask) | (s.charAt(i) - '0');
19
20            // Start checking only after we have k bits
21            if (i >= k - 1) {
22                if (!seen[cur]) {
23                    seen[cur] = true;
24                    count++;
25                    if (count == need) {
26                        return true;
27                    }
28                }
29            }
30        }
31        return false;
32    }
33}
34