1class Solution {
2    public int maximumJumps(int[] nums, int target) {
3        int n = nums.length;
4        int[] dp = new int[n];
5        for (int i = 0; i < n; i++) dp[i] = Integer.MIN_VALUE;
6        dp[0] = 0;
7
8        for (int j = 1; j < n; j++) {
9            for (int i = 0; i < j; i++) {
10                long diff = (long) nums[j] - nums[i];
11                if (diff >= - (long) target && diff <= (long) target && dp[i] != Integer.MIN_VALUE) {
12                    dp[j] = Math.max(dp[j], dp[i] + 1);
13                }
14            }
15        }
16
17        return dp[n - 1] < 0 ? -1 : dp[n - 1];
18    }
19}