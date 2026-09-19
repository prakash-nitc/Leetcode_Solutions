class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue= new LinkedList<>();
        int time=0;

        for(int i=0; i<tickets.length; i++)
        {
            queue.add(i);
        }
        while(tickets[k]>0)
        {
            int person= queue.poll();

            tickets[person]--;
            time++;

            if(tickets[person]>0)
            {
                queue.add(person);
            }
        }
        return time;

    }
}