1class Solution {
2    public int maxSubArray(int[] nums) {
3        int best_ending=nums[0];
4        int largest_sum= nums[0];
5
6        for(int i=1; i<nums.length; i++)
7        {
8            int choice1= best_ending+ nums[i];
9            int choice2= nums[i];
10
11            best_ending= Math.max(choice1, choice2);
12            largest_sum= Math.max(largest_sum, best_ending);
13        }
14        return largest_sum;
15    }
16}