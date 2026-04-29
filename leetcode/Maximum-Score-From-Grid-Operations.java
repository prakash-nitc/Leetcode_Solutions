1class Solution {
2    public long maximumScore(int[][] grid) {
3        int n = grid.length;
4        if (n == 1) {
5            return 0;
6        }
7        long[][][] dp = new long[n][n + 1][n + 1];
8        long[][] prevMax = new long[n + 1][n + 1];
9        long[][] prevSuffixMax = new long[n + 1][n + 1];
10        long[][] colSum = new long[n][n + 1];
11        
12        for (int c = 0; c < n; c++) {
13            for (int r = 1; r <= n; r++) {
14                colSum[c][r] = colSum[c][r - 1] + grid[r - 1][c];
15            }
16        }
17        
18        for (int i = 1; i < n; i++) {
19            for (int currH = 0; currH <= n; currH++) {
20                for (int prevH = 0; prevH <= n; prevH++) {
21                    if (currH <= prevH) {
22                        long extraScore = colSum[i][prevH] - colSum[i][currH];
23                        dp[i][currH][prevH] = prevSuffixMax[prevH][0] + extraScore;
24                    } else {
25                        long extraScore = colSum[i - 1][currH] - colSum[i - 1][prevH];
26                        dp[i][currH][prevH] = Math.max(
27                            prevSuffixMax[prevH][currH],
28                            prevMax[prevH][currH] + extraScore
29                        );
30                    }
31                }
32            }
33            
34            for (int currH = 0; currH <= n; currH++) {
35                prevMax[currH][0] = dp[i][currH][0];
36                for (int prevH = 1; prevH <= n; prevH++) {
37                    long penalty = prevH > currH ? colSum[i][prevH] - colSum[i][currH] : 0;
38                    prevMax[currH][prevH] = Math.max(
39                        prevMax[currH][prevH - 1],
40                        dp[i][currH][prevH] - penalty
41                    );
42                }
43                
44                prevSuffixMax[currH][n] = dp[i][currH][n];
45                for (int prevH = n - 1; prevH >= 0; prevH--) {
46                    prevSuffixMax[currH][prevH] = Math.max(
47                        prevSuffixMax[currH][prevH + 1],
48                        dp[i][currH][prevH]
49                    );
50                }
51            }
52        }
53        
54        long answer = 0;
55        for (int k = 0; k <= n; k++) {
56            answer = Math.max(answer, Math.max(dp[n - 1][0][k], dp[n - 1][n][k]));
57        }
58        return answer;
59    }
60}