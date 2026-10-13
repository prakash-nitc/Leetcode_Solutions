class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int best_ending1= nums[0], best_ending2= nums[0];
        int maxSum= nums[0], minSum= nums[0];
        int sum= nums[0], result=0;

        for(int i=1; i< nums.length; i++)
        {
            sum+= nums[i];

            best_ending1= Math.max(nums[i], best_ending1+nums[i]);
            maxSum= Math.max(maxSum, best_ending1);

            best_ending2= Math.min(nums[i], best_ending2+nums[i]);
            minSum= Math.min(minSum, best_ending2);
        }
        if(maxSum<0)
            return maxSum;
        else 
            return Math.max(maxSum, sum-minSum);
    }
}