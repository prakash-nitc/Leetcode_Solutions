class Solution {
    public int result(int weights[], int capacity)
    {
        int days=1, sum=0;
        for(int i=0; i<weights.length; i++)
        {
            
            if(sum+weights[i]<=capacity)
            {
                sum+= weights[i];
            }
            else
            {
                days++;
                sum=weights[i];
            }   
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int n= weights.length;
        int sum=0,high=0;
        int result=0;
        for(int i=0; i<n; i++)
        {
            sum+= weights[i];
            if(weights[i]> low)
                low= weights[i];
        }
        high= sum;
        while(low<=high)
        {
            int mid= (low+high)/2;
            int totaldays= result(weights, mid);

            if(totaldays> days)
                low=mid+1;
            else
            {
                result= mid;
                high= mid-1;
            }

        }
        return result;
    }
}