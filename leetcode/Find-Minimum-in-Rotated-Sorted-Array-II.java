1class Solution {
2    public int findMin(int[] nums) {
3        int n = nums.length;
4        for (int i = 1; i < n; i++) {
5            if (nums[i] < nums[i - 1]) {
6                return nums[i];
7            }
8        }
9        return nums[0];
10    }
11}