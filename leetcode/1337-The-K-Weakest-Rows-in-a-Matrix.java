class Solution {
    class Pair
    {
        int index;
        int soldiers;
        Pair(int index, int soldiers )
        {
            this.index= index;
            this.soldiers= soldiers;
        }
    }

    public int countSoldiers(int [][]mat, int row)
    {
        int count=0;
        for(int col=0; col< mat[0].length; col++)
        {
            if(mat[row][col]==1)
                count++;
        }
        return count;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->{
            if(a.soldiers!=b.soldiers)
                return b.soldiers-a.soldiers;
            else
                return b.index-a.index;
        });

        for(int i=0; i<mat.length; i++)
        {
            int soldiers= countSoldiers(mat, i);
            Pair current= new Pair(i, soldiers);

            if(pq.size()<k)
                pq.add(current);
            else
            {
                if(pq.comparator().compare(current, pq.peek())>0)
                {
                    pq.poll();
                    pq.add(current);
                }
            }
        }
        int ans[]= new int[k];
        for(int i=k-1;i>=0; i--)
        {
            ans[i]= pq.poll().index;
        }
        
        return ans;

        
    }
}