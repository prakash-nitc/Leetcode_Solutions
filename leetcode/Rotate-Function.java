1class Solution {
2    public int maxRotateFunction(int[] nums) {
3        int n = nums.length;
4        long sum = 0;
5        long f0 = 0;
6        for (int i = 0; i < n; i++) {
7            sum += nums[i];
8            f0 += (long) i * nums[i];
9        }
10        long max = f0;
11        long fk = f0;
12        for (int k = 1; k < n; k++) {
13            fk = fk + sum - (long) n * nums[n - k];
14            if (fk > max) {
15                max = fk;
16            }
17        }
18        return (int) max;
19    }
20}