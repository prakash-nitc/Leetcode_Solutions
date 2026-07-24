class Solution 
{
    public int[] searchRange(int[] nums, int target) {
        
        int first_occurence= findFirstOccurence(nums, target);
        int last_occurence= findLastOccurence(nums, target);

        return new int[]{first_occurence, last_occurence};

    }

    public int findFirstOccurence(int[] nums, int target)
    {
        int low=0;
        int high= nums.length-1;
        int result=-1;
        while(low<= high)
        {
            int guess= (low+high)/2;

            if(nums[guess]== target)
            {
                result= guess;
                high= guess-1;
            }
            else if(nums[guess]<target)
                low= guess+1;
            else
                high= guess-1;
        }
        return result;
    }

    public int findLastOccurence(int[] nums, int target)
    {
        int low=0;
        int high= nums.length-1;
        int result=-1;
        while(low<= high)
        {
            int guess= (low+high)/2;

            if(nums[guess]== target)
            {
                result= guess;
                low=guess+1;
            }
            else if(nums[guess]<target)
                low= guess+1;
            else
                high= guess-1;
        }
        return result;
    }
}