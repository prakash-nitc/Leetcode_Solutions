1class Solution {
2    public int minSubArrayLen(int target, int[] nums) {
3        int high=0, low=0, sum=0,length=0, result=Integer.MAX_VALUE;
4        int n= nums.length;
5
6        while(high < n)
7        {
8            sum = sum+ nums[high];
9            while(sum>=target)
10            {
11                
12                length = high-low+1;
13                result = Math.min(result, length );
14                sum = sum- nums[low++];
15                
16            }
17            high++;
18        }
19        if ( result == Integer.MAX_VALUE)
20        return 0;
21        else
22        return result;
23    }
24}