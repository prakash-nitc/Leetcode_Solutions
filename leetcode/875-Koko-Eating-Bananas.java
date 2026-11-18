class Solution {

    public long hours(int nums[],long speed)
    {
        long k=0;
        for(int i=0; i<nums.length; i++)
        {
            k= k+ nums[i]/speed;
            if(nums[i]%speed!=0)
                k++;
        }
        return k;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n= piles.length;
        long low=1, high=0;
        long result=-1;

        for(int i=0; i<n; i++)
        {
            if(piles[i]>high)
                high= piles[i];
        }
        while(low<=high)
        {
            long mid= (low+high)/2;
            long hour= hours(piles,mid);

            if(hour> h)
                low= mid+1;
            else
            {
                result= mid;
                high=mid-1;
            }
        }
        return (int)result;
    }
}