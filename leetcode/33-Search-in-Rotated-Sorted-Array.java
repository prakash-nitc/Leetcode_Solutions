class Solution {

    public int binarySearch(int low, int high,int nums[], int target)
    {
        while(low<= high)
        {
            int guess= (low+high)/2;

            if(nums[guess]== target)
                return guess;
            if(nums[guess]<target)
                low= guess+1;
            else
                high= guess-1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int low=0;
        int high= nums.length-1;
        int index=-1;

        while(low<=high)
        {
            int guess= (low+high)/2;
            if(nums[guess]> nums[nums.length-1])
            {
                low= guess+1;
            }
            else
            {
                index= guess;
                high= guess-1;
            }
        }
        int search1= binarySearch(0, index-1,nums, target);
        int search2= binarySearch(index, nums.length-1,nums, target );

        if(search1== -1)
            return search2;
        else
            return search1;
    }
}