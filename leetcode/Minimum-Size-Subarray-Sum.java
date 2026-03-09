1class Solution {
2    public int minSubArrayLen(int target, int[] nums) {
3        int low=0,high=0;
4        int result= Integer.MAX_VALUE;
5        int sum=0, n= nums.length;
6
7        while(high<n)
8        {
9            sum= sum+ nums[high];
10
11            while(sum>=target)
12            {
13                int len = high-low+1;
14                result= Math.min(result, len);
15                sum= sum-nums[low];
16                low++;
17            }
18            high++;
19        }
20        if( result== Integer.MAX_VALUE)
21        return 0;
22        else 
23        return result;
24    }
25}