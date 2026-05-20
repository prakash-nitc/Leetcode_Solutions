1class Solution {
2    public int[] findThePrefixCommonArray(int[] A, int[] B) {
3        int n = A.length;
4        int[] freq = new int[n + 1];
5        int[] ans = new int[n];
6        int common = 0;
7        for (int i = 0; i < n; i++) {
8            if (++freq[A[i]] == 2) common++;
9            if (++freq[B[i]] == 2) common++;
10            ans[i] = common;
11        }
12        return ans;
13    }
14}