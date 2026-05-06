1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        int n = triangle.size();
4        int[] dp = new int[n];
5        for (int j = 0; j < n; j++) {
6            dp[j] = triangle.get(n - 1).get(j);
7        }
8        for (int i = n - 2; i >= 0; i--) {
9            for (int j = 0; j <= i; j++) {
10                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
11            }
12        }
13        return dp[0];
14    }
15}