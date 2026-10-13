class Solution {
    public int maxProduct(int[] nums) {
        int max_ending= nums[0];
        int min_ending= nums[0];
        int ans=nums[0];

        for(int i=1; i< nums.length; i++)
        {
            int choice1= max_ending* nums[i];
            int choice2= min_ending*nums[i];
            int choice3= nums[i];

            max_ending= Math.max(choice3, Math.max(choice1, choice2));
            min_ending= Math.min(choice3, Math.min(choice1, choice2));

            ans= Math.max(ans, max_ending);
        }

        return ans;
    }
}