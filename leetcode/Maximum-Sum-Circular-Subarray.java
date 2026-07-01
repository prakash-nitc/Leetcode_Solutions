1class Solution {
2    public int maxSubarraySumCircular(int[] nums) {
3        int best_ending1= nums[0], best_ending2= nums[0];
4        int maximum_sum= nums[0], minimum_sum= nums[0];
5        int sum=nums[0], result;
6
7
8        for(int i=1; i<nums.length; i++)
9        {
10            sum+= nums[i];
11            //for maximum sum
12            best_ending1= Math.max(best_ending1+nums[i], nums[i]);
13            maximum_sum= Math.max(maximum_sum, best_ending1);
14
15            //for minimum sum
16            best_ending2= Math.min(best_ending2+nums[i], nums[i]);
17            minimum_sum= Math.min(minimum_sum, best_ending2);
18
19        }
20        
21        if(maximum_sum<0) //i.e. whole array has -ve elements
22        return maximum_sum;
23
24        result= Math.max(maximum_sum, sum-minimum_sum);
25        return result;
26    }
27}