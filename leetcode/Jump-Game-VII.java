1class Solution {
2    public boolean canReach(String s, int minJump, int maxJump) {
3        int n = s.length();
4        if (s.charAt(n - 1) == '1') return false;
5
6        boolean[] dp = new boolean[n];
7        dp[0] = true;
8        int window = 0;
9
10        for (int i = 1; i < n; i++) {
11            int addIdx = i - minJump;
12            if (addIdx >= 0 && dp[addIdx]) {
13                window++;
14            }
15
16            int removeIdx = i - maxJump - 1;
17            if (removeIdx >= 0 && dp[removeIdx]) {
18                window--;
19            }
20
21            dp[i] = s.charAt(i) == '0' && window > 0;
22        }
23
24        return dp[n - 1];
25    }
26}