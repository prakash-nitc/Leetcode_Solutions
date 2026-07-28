class Solution {

    public boolean possible(int arr[], int guess, int days)
    {
        int sum=0, total_days=1;
        for(int i=0; i<arr.length; i++)
        {
            if(sum+arr[i]<= guess)
            {
                sum+= arr[i];
            }
            else
            {
                total_days++;
                sum= arr[i];
            }
        }
        if(total_days> days)
            return false;
        else
            return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max=0, total=0;
        for(int i=0; i< weights.length; i++)
        {
            max= Math.max(max, weights[i]);
            total+= weights[i];
        }
        int low= max, high= total;
        int result= -1;

        while(low<=high)
        {
            int guess= (low+high)/2;
            if(possible(weights, guess, days))
            {
                result= guess;
                high= guess-1;
            }
            else
                low= guess+1;
        } 
        return result;

        
    }
}