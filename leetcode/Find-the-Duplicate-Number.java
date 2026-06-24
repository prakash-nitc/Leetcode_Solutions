1class Solution {
2    public int findDuplicate(int[] nums) {
3        int slow=0;
4        int fast=0;
5
6        while(true)
7        {
8            slow= nums[slow];
9            fast= nums[fast];
10            fast= nums[fast];
11
12            if(slow == fast)
13            {
14                slow= 0;
15                while(slow!=fast)
16                {
17                    slow= nums[slow];
18                    fast= nums[fast];
19                }
20                return slow;
21            }
22        }
23    }
24}