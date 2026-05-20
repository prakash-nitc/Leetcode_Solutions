1class Solution {
2    public int[] findThePrefixCommonArray(int[] A, int[] B) {
3        int n = A.length;
4        int[] freq = new int[n + 1];
5        int[] ans = new int[n];
6        int common = 0;
7
8        for (int i = 0; i < n; i++) {
9            freq[A[i]]++;
10            if (freq[A[i]] == 2) {
11                common++;
12            }
13
14            freq[B[i]]++;
15            if (freq[B[i]] == 2) {
16                common++;
17            }
18
19            ans[i] = common;
20        }
21
22        return ans;
23    }
24}