class Solution {

    public int divisorsum(int nums[], int n)
    {
        int sum=0;
        for(int i=0; i<nums.length; i++)
        {
            double div= (double)nums[i]/n;
            sum+= Math.ceil(div);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1, high=-1, result=-1;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]> high)
                high= nums[i];
        }

        while(low<=high)
        {
            int mid= (low+high)/2;
            int sum= divisorsum(nums, mid);

            if(sum>threshold)
                low= mid+1;
            else
            {
                result= mid;
                high= mid-1;
            }

        }
        return result;
    }
}