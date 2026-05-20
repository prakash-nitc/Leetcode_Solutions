1import java.util.*;
2
3class Solution {
4    public int[] findThePrefixCommonArray(int[] A, int[] B) {
5        int n = A.length;
6        int[] ans = new int[n];
7        Set<Integer> set = new HashSet<>();
8        int common = 0;
9
10        for (int i = 0; i < n; i++) {
11            if (set.contains(A[i])) {
12                common++;
13            } else {
14                set.add(A[i]);
15            }
16
17            if (set.contains(B[i])) {
18                common++;
19            } else {
20                set.add(B[i]);
21            }
22
23            ans[i] = common;
24        }
25
26        return ans;
27    }
28}