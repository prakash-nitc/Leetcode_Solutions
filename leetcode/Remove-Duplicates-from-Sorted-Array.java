1class Solution {
2    public int removeDuplicates(int[] nums) {
3        
4        int off=0;
5        int cm=1, res=0;
6
7        while(cm< nums.length)
8        {
9            if(nums[cm]==nums[cm-1])
10            {
11                cm++;
12                continue;
13            }
14            else
15            {
16                nums[off+1]=nums[cm];
17                off++;
18                cm++;
19                res++;
20            }
21        }
22        return res+1;
23        
24    }
25}
26