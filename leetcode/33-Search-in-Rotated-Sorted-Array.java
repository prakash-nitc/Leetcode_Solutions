class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high= nums.length-1;
        int index=-1;

        while(low<=high)
        {
            int guess= (low+high)/2;
            if(nums[guess]==target)
                return guess;
            
            if(nums[guess]> nums[nums.length-1])
            {
                
                if(nums[guess]< target)
                    low= guess+1;
                else
                {
                    if(nums[0]> target)
                        low= guess+1;
                    else
                        high= guess-1;
                }
                continue;
            }
            else
            {
                if(nums[guess]> target)
                    high= guess-1;
                else 
                {
                    if(nums[nums.length-1]< target)
                        high= guess-1;
                    else
                        low= guess+1;
                }
            }
        }
        return -1;
        
    }
}