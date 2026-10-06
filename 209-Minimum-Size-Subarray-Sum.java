class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low=0, high=0, minLength=Integer.MAX_VALUE, sum=0;

        for(high=0; high<nums.length; high++)
        {
            sum+= nums[high];

            while(sum>=target)
            {
                minLength= Math.min(minLength, high-low+1);
                sum-=  nums[low];
                low++;
            }
        }
        if(minLength==Integer.MAX_VALUE)
            return 0;
        else
            return minLength;
    }
}