class Solution {

    public boolean possible(int arr[], long n, long guess, long k )
    {
        long child=0;
        for(int i=0; i<n; i++)
        {
            child= arr[i]/guess; //no of children possible from 1 pile
            k-=child;
        }
        if(k<=0)
            return true;
        else
            return false;
    }

    public int maximumCandies(int[] candies, long k) {
        long max=Integer.MIN_VALUE, total=0;
        long n= candies.length;
        for(int i=0; i<n; i++)
        {
            max= Math.max(max, candies[i]);
            total+= candies[i];
        }
        //edge case
        if(total<k)
            return 0;
        long low=1, high= max;
        long result=0;

        while(low<=high)
        {
            long guess= (low+high)/2;
            if(possible(candies, n, guess,k))
            {
                result= guess;
                low= guess+1;
            }
            else
                high= guess-1;
        }
        return (int)result;
    }
}