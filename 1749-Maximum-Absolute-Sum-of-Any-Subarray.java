class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int best_ending1= nums[0], best_ending2= nums[0];
        int maxSum= nums[0], minSum= nums[0];
        int max_absSum=0;

        for(int i=1; i<nums.length; i++)
        {
            int choice11= best_ending1+nums[i];
            int choice12= best_ending2+nums[i];
            int choice2= nums[i];

            best_ending1= Math.max(choice11, choice2);
            maxSum= Math.max(maxSum, best_ending1);

            best_ending2= Math.min(choice12, choice2);
            minSum= Math.min(minSum, best_ending2);
        }
        max_absSum= Math.max(maxSum, Math.abs(minSum));

        return max_absSum;
    }
}