class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0, high= nums.length-1, result=-1;

        while(low<high)
        {
            int guess= (low+high)/2;

            if(nums[guess]==nums[guess+1])
            {
                int eveodd= (nums.length-1)-guess;
                if(eveodd%2==0)
                    low=guess+2;
                else
                    high=guess-1; 
            }
            else 
            {
                int eveodd= (nums.length-1)-guess; //kept mid not mid+1
                if(eveodd%2==0)
                    high= guess-1;
                else
                    low=guess+1; 
            }
            

        }
        return nums[low];

    }
}