class Solution {

    public boolean bouquet_possible(int arr[],int guess, int m, int k)
    {
        int n= arr.length;
        int flowers=0, bouquets=0;
        for(int i=0; i<n; i++)
        {
            if(arr[i]<= guess)
            {
                flowers++;
                if(flowers==k)
                {
                    bouquets++;
                    flowers=0;
                }
            }
            else
                flowers=0;
        }
        if(bouquets>=m)
            return true;
        else
            return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long max= Integer.MIN_VALUE;
        long min= Integer.MAX_VALUE;
        int n= bloomDay.length;

        for(int i=0; i<n; i++)
        {
            if(bloomDay[i]>max)
                max= bloomDay[i];
            if(bloomDay[i]<min)
                min= bloomDay[i];
        }

        long low=min, high= max;
        long result=-1;

        if(n< (long)m*k)
            return -1;

        while(low<=high)
        {
            long guess= (low+high)/2;
            if(bouquet_possible(bloomDay,(int)guess,m,k))
            {
                result=guess;
                high= guess-1;

            }
            else
                low=guess+1;
        }
        return (int)result;

    }
}