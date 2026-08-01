class Solution {
    public int lastStoneWeight(int[] stones) {

        //edgecase
        if(stones.length==1)
            return stones[0];

        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a );
        for(int i=0; i<stones.length; i++)
        {
            pq.add(stones[i]);
        }

        while(pq.size()>1) //can i do another smash, for that 2 stones needed
        {
            int y= pq.poll();
            int x= pq.poll();

            if(x==y)
                continue;
            else
            {
                pq.add(y-x);
            }
        }
        if(pq.size()>0)
            return pq.poll();
        else
            return 0;
        
    }
}