class Solution {
    public int hIndex(int[] citations) {
        int low= 0, high= citations.length-1;
        int result=0;
        while(low<=high)
        {
            int guess= (low+high)/2;
            int papers= citations.length- guess;
            
            if(citations[guess]== papers)
                return papers;
            else if (citations[guess]< papers)
                low= guess+1;
            else
                high= guess-1;
        }
        return citations.length-low;
    }
}
