1class Solution {
2    public int findMaxLength(int[] nums) {
3        int zeros=0, ones=0, res=0, diff=0;
4        HashMap <Integer, Integer> map= new HashMap<>();
5
6        for(int i=0; i<nums.length; i++)
7        {
8            if(nums[i]==0)
9                zeros++;
10            else
11                ones++;
12
13            diff= zeros-ones;
14            // Edge case: if difference is 0, the entire array up to i is valid
15            if(diff==0)
16            {
17                res= Math.max(res, i+1);
18                continue;
19            }
20            if(map.containsKey(diff))
21            {// If difference has been seen before, calculate length
22                int index= map.get(diff);
23                res= Math.max(res, i-index);
24            }
25            else
26                map.put(diff,i); // Store the first occurrence index
27        }
28        return res;
29    }
30}
31