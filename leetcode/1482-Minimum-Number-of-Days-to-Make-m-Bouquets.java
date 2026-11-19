class Solution {
    public int countBouquets(int[] bloomDay, int day, int k)
    {
        int bouquets=0, consecutive=0;
        for(int i=0; i<bloomDay.length; i++)
        {
            if(bloomDay[i]<= day)
            {
                consecutive++;
                if(consecutive==k)
                {
                    bouquets++;
                    consecutive=0;
                }
            }
            else
                consecutive=0;
        }
        return bouquets;
        
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low=1,high=-1, result=-1;

        for(int i=0; i<bloomDay.length; i++)
        {
            if(bloomDay[i]>high)
                high= bloomDay[i];
        }

        while(low<=high)
        {
            int mid= (low+high)/2;
            int totalbouquets= countBouquets(bloomDay, mid, k);

            if(totalbouquets< m)
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