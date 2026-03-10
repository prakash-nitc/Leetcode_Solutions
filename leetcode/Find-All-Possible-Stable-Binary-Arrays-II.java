1class Solution {
2    private static final int MOD = (int) 1e9 + 7;
3    private static final int N = 1000;
4    private static long[] fact = null;
5    private static long[] invFact = null;
6
7    public int numberOfStableArrays(int zero, int one, int limit) {
8        initFactorials();
9
10        long ans = 0;
11        long[] cache = new long[one + 1]; // cache for calc(groups1, one, limit)
12
13        int maxGroups = Math.min(zero, one) + 1;
14
15        // groups0 = number of zero-blocks
16        for (int groups0 = (zero + limit - 1) / limit; groups0 <= Math.min(zero, maxGroups); ++groups0) {
17            long waysZero = calc(groups0, zero, limit);
18
19            // groups1 = number of one-blocks
20            int startG1 = Math.max(groups0 - 1, (one + limit - 1) / limit);
21            int endG1 = Math.min(groups0 + 1, one);
22
23            for (int groups1 = startG1; groups1 <= endG1; ++groups1) {
24                long waysOne;
25                if (cache[groups1] != 0) {
26                    waysOne = cache[groups1];
27                } else {
28                    waysOne = calc(groups1, one, limit);
29                    cache[groups1] = waysOne;
30                }
31                long ways = waysZero * waysOne % MOD;
32                // if groups0 == groups1, arrays can start with 0 or 1 (factor 2), else only 1 way
33                if (groups0 == groups1) {
34                    ways = ways * 2 % MOD;
35                }
36                ans = (ans + ways) % MOD;
37            }
38        }
39
40        if (ans < 0) ans += MOD;
41        return (int) ans;
42    }
43
44    // number of ways to split x items (zeros or ones) into `groups` blocks,
45    // each block size in [1, limit]
46    private long calc(int groups, int x, int limit) {
47        long res = 0;
48        int sign = 1;
49        // Inclusion–exclusion over k blocks that violate the limit
50        for (int k = 0; k * limit <= x - groups && k <= groups; ++k) {
51            long term = comb(groups, k) *
52                        comb(x - k * limit - 1, groups - 1) % MOD;
53            if (sign == 1) {
54                res = (res + term) % MOD;
55            } else {
56                res = (res - term + MOD) % MOD;
57            }
58            sign ^= 1;
59        }
60        return res;
61    }
62
63    private void initFactorials() {
64        if (fact != null) return;
65        fact = new long[N + 1];
66        invFact = new long[N + 1];
67        fact[0] = invFact[0] = 1;
68        long x = 1;
69        for (int i = 1; i <= N; ++i) {
70            x = x * i % MOD;
71            fact[i] = x;
72        }
73        // Fermat inverse for factorial[N]
74        long inv = modPow(fact[N], MOD - 2);
75        invFact[N] = inv;
76        for (int i = N; i > 0; --i) {
77            invFact[i - 1] = invFact[i] * i % MOD;
78        }
79    }
80
81    private long comb(int n, int k) {
82        if (k < 0 || k > n) return 0;
83        return (((fact[n] * invFact[k]) % MOD) * invFact[n - k]) % MOD;
84    }
85
86    private long modPow(long base, long exp) {
87        long res = 1;
88        while (exp > 0) {
89            if ((exp & 1) == 1) res = res * base % MOD;
90            base = base * base % MOD;
91            exp >>= 1;
92        }
93        return res;
94    }
95}
96