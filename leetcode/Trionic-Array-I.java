1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int n = nums.length;
4        if (n < 3) return false;
5
6        // p: 0 < p < n - 1  => 1 .. n-2
7        for (int p = 1; p <= n - 2; p++) {
8            // q: p < q < n - 1 => p+1 .. n-2
9            for (int q = p + 1; q <= n - 2; q++) {
10                if (isIncreasing(nums, 0, p) &&
11                    isDecreasing(nums, p, q) &&
12                    isIncreasing(nums, q, n - 1)) {
13                    return true;
14                }
15            }
16        }
17        return false;
18    }
19
20    // check nums[start..end] strictly increasing
21    private boolean isIncreasing(int[] nums, int start, int end) {
22        for (int i = start; i < end; i++) {
23            if (nums[i] >= nums[i + 1]) {
24                return false;
25            }
26        }
27        return true;
28    }
29
30    // check nums[start..end] strictly decreasing
31    private boolean isDecreasing(int[] nums, int start, int end) {
32        for (int i = start; i < end; i++) {
33            if (nums[i] <= nums[i + 1]) {
34                return false;
35            }
36        }
37        return true;
38    }
39}
40