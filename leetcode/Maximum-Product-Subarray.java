1class Solution {
2    public int maxProduct(int[] nums) {
3        int min_ending=nums[0];
4        int max_ending=nums[0];
5        int ans= nums[0];
6
7        for(int i=1; i<nums.length; i++)
8        {
9            int choice1= max_ending* nums[i];
10            int choice2= min_ending*nums[i];
11            int choice3= nums[i];
12
13            max_ending= Math.max(choice3, Math.max(choice1, choice2));
14            min_ending= Math.min(choice3, Math.min(choice1, choice2));
15
16            ans= Math.max(ans, max_ending);
17        }
18        return ans;
19    }
20}