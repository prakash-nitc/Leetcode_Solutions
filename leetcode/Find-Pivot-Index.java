1class Solution {
2    public int pivotIndex(int[] nums) {
3        int n= nums.length;
4        int sum=0;
5
6        for(int i=0; i<n; i++)
7        {
8            sum+= nums[i];
9        }
10
11        int left=0;
12        for(int i=0;i<n; i++)
13        {
14            int right= sum-left-nums[i];
15            if(left==right)
16            {
17                return i;
18            }
19            left+= nums[i];
20        }
21        return -1;
22    }
23}