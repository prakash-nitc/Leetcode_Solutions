1class Solution {
2    public int maxAbsoluteSum(int[] nums) {
3        int best_ending1= nums[0], best_ending2= nums[0];
4        int maximum_sum= nums[0], minimum_sum= nums[0];
5        int max_abs_sum=0;
6
7        for(int i=1; i<nums.length; i++)
8        {
9            //for maximum sum
10            best_ending1= Math.max(best_ending1+nums[i], nums[i]);
11            maximum_sum= Math.max(maximum_sum, best_ending1);
12
13            //for minimum sum
14            best_ending2= Math.min(best_ending2+nums[i], nums[i]);
15            minimum_sum= Math.min(minimum_sum, best_ending2);
16
17        }
18        
19        max_abs_sum= Math.max(maximum_sum, Math.abs(minimum_sum));
20        return max_abs_sum;
21    }
22}