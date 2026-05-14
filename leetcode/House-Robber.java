1class Solution {
2    public int rob(int[] nums) {
3        if (nums.length == 1) {
4            return nums[0];
5        }
6        int prev2 = nums[0];
7        int prev1 = Math.max(nums[0], nums[1]);
8        for (int i = 2; i < nums.length; i++) {
9            int current = Math.max(prev1, prev2 + nums[i]);
10            prev2 = prev1;
11            prev1 = current;
12        }
13        return prev1;
14    }
15}