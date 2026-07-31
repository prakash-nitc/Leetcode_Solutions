class Solution {
    public int distance_from_centre(int[][] points,int index)
    {
        int x1= points[index][0];
        int y1= points[index][1];

        return x1*x1+ y1*y1; // x1^2-0^2 + y1^2-0^2, no need of sq root
        
    }

    class Pair
    {
        int  distance, index;
        Pair( int distance, int index)
        {
            this.distance= distance;
            this.index= index;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue <Pair> pq= new PriorityQueue<>((a,b)-> b.distance- a.distance);

        for(int i=0; i<points.length; i++)
        {
            int distance= distance_from_centre(points, i);
            Pair current= new Pair(distance, i);

            if(pq.size()<k)
            {
                pq.add(current);
            }
            else
            {
                if(current.distance< pq.peek().distance)
                {
                    pq.poll();
                    pq.add(current);
                }
            }
        }

        int [][]ans= new int [k][2] ;
        for(int i=0; i< k; i++)
        {
            int index= pq.poll().index;
            ans[i][0]= points[index][0];
            ans[i][1]= points[index][1];
        }
        return ans;
                        
    }
}