class Solution {

    class Pair
    {
        int distance, value;
        Pair(int distance, int value)
        {
            this.distance= distance;
            this.value= value;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> {
            if(a.distance!=b.distance)
                return b.distance- a.distance;
            else
                return b.value- a.value;//we're comparing the values stored in arr, not the indices.
        });

        for(int i=0; i< arr.length; i++)
        {
            int distance= Math.abs(arr[i]-x);
            Pair current= new Pair(distance, arr[i]);

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
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=0; i<k; i++) 
        {
            ans.add( pq.poll().value);
        }
        Collections.sort(ans);//Sorting since Reversing the heap output does not always guarantee ascending order.
        return ans;
    }
}