1class Solution {
2    public int minMoves(int[] nums, int limit) {
3        int n = nums.length;
4        int[] diff = new int[2 * limit + 2];
5
6        for (int i = 0; i < n / 2; i++) {
7            int a = nums[i];
8            int b = nums[n - 1 - i];
9            int low = Math.min(a, b);
10            int high = Math.max(a, b);
11
12            diff[2] += 2;
13            diff[low + 1] -= 2;
14
15            diff[low + 1] += 1;
16            diff[low + high] -= 1;
17
18            diff[low + high + 1] += 1;
19            diff[high + limit + 1] -= 1;
20
21            diff[high + limit + 1] += 2;
22        }
23
24        int ans = n;
25        int cur = 0;
26        for (int s = 2; s < diff.length; s++) {
27            cur += diff[s];
28            ans = Math.min(ans, cur);
29        }
30        return ans;
31    }
32}