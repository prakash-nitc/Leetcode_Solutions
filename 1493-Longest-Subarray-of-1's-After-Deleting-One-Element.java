class Solution {
    public int longestSubarray(int[] nums) {
        int low=0, high=0, maxLength=0, zeros=0;

        for(high=0; high<nums.length; high++)
        {
            if(nums[high]==0)
            {
                zeros++;
            }
            while(zeros>1)
            {
                if(nums[low]==0)
                    zeros--;
                low++;
            }
            maxLength= Math.max(maxLength, high-low);
            
        }
        return maxLength;

    }
}