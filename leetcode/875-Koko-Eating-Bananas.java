class Solution {

    public long TimeTakenByKoko(int[] piles, int guess)
    {
        long hours=0;
        for(int i=0; i<piles.length; i++)
        {
            hours+= piles[i]/guess;
            if(piles[i]%guess!=0)
                hours++;
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int max=0;
        for(int i=0; i<piles.length; i++)
        {
            if(piles[i]> max)
            max= piles[i];
        }
        int high= max;
        int result=-1;

        while(low<= high)
        {
            int guess= (low+high)/2;
            long total_time= TimeTakenByKoko(piles, guess); 

            if(total_time> h)
                low= guess+1;
            else
            {
                result= guess;
                high= guess-1;
            }
        }
        return result;
    }
}