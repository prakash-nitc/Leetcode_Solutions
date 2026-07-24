class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high= nums.length-1;
        int result=-1;

        while(low<=high)
        {
            int guess= (low+high)/2;
            if( nums[guess]> nums[nums.length-1])
            {
                low= guess+1;
            }
            else
            {
                result= guess;
                high= guess-1;
            }
        }
        return nums[result];
    }
}