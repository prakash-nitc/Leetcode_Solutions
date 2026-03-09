1class Solution {
2    private static final int MOD = 1_000_000_007;
3
4    public int numberOfStableArrays(int zero, int one, int limit) {
5        // dp[z][o][last][run] = number of ways
6        // last = 0 or 1 (what is the last bit)
7        long[][][][] dp = new long[zero + 1][one + 1][2][limit + 1];
8
9        // Initialize: we can start with a 0 or with a 1
10        if (zero > 0) {
11            dp[1][0][0][1] = 1;
12        }
13        if (one > 0) {
14            dp[0][1][1][1] = 1;
15        }
16
17        for (int z = 0; z <= zero; z++) {
18            for (int o = 0; o <= one; o++) {
19                for (int last = 0; last < 2; last++) {
20                    for (int run = 1; run <= limit; run++) {
21                        long cur = dp[z][o][last][run];
22                        if (cur == 0) continue;
23
24                        // Append 0
25                        if (z < zero) {
26                            if (last == 0) {
27                                // Continue run of 0s if we do not exceed limit
28                                if (run < limit) {
29                                    dp[z + 1][o][0][run + 1] =
30                                            (dp[z + 1][o][0][run + 1] + cur) % MOD;
31                                }
32                            } else {
33                                // Switch from 1 to 0, run resets to 1
34                                dp[z + 1][o][0][1] =
35                                        (dp[z + 1][o][0][1] + cur) % MOD;
36                            }
37                        }
38
39                        // Append 1
40                        if (o < one) {
41                            if (last == 1) {
42                                // Continue run of 1s if we do not exceed limit
43                                if (run < limit) {
44                                    dp[z][o + 1][1][run + 1] =
45                                            (dp[z][o + 1][1][run + 1] + cur) % MOD;
46                                }
47                            } else {
48                                // Switch from 0 to 1, run resets to 1
49                                dp[z][o + 1][1][1] =
50                                        (dp[z][o + 1][1][1] + cur) % MOD;
51                            }
52                        }
53                    }
54                }
55            }
56        }
57
58        long ans = 0;
59        for (int last = 0; last < 2; last++) {
60            for (int run = 1; run <= limit; run++) {
61                ans = (ans + dp[zero][one][last][run]) % MOD;
62            }
63        }
64        return (int) ans;
65    }
66}
67