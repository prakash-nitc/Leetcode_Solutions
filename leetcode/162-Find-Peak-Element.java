class Solution {
    public int findPeakElement(int[] nums) {
        int low=1, high= nums.length-2;
        int result=-1;

        //edge cases
        if(nums.length==1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        if(nums[nums.length-1]> nums[nums.length-2])
            return nums.length-1;
        while(low<=high)
        {
            int guess= (low+high)/2;
            if(nums[guess]< nums[guess+1])
                low= guess+1;
            else
            {
                result= guess;
                high= guess-1;
            }
        }
        return result;
    }
}