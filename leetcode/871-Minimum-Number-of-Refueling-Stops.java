class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) 
    {
    
     PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a);
     int reach= startFuel;
     int idx=0;
     int stops=0; 

     while(reach< target)
     {
        // Add all newly reachable stations.
        while(idx< stations.length && stations[idx][0]<=reach )
        {
            pq.add(stations[idx][1]);
            idx++;
        }

        if(pq.isEmpty())
        {
            return -1;
        }
        else
        {
            reach+= pq.poll();
            stops++;
        }
     }
     return stops;  
    }
}