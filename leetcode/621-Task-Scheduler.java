class Solution {
    //We'll need a class for the cooling queue.
    class Pair 
    {
        int freq;
        int availableTime;

        Pair(int freq, int availableTime) 
        {
            this.freq = freq;
            this.availableTime = availableTime;
        }
    }      

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a);
        Queue<Pair> q= new ArrayDeque<>();
        int time=0;

        for(int i=0; i<tasks.length; i++)
        {
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet())
        {
            pq.add(entry.getValue());
        }

        //Continue while the heap has tasks OR the queue has tasks.
        while(!pq.isEmpty() || !q.isEmpty())
        {
            time++;// time will keep going , in this time we have several cases that we will perform.

            //case1:
            //If task's cooldown has finished, poll from queue, add to heap
            if(!q.isEmpty() && q.peek().availableTime== time)
            {
                Pair p= q.poll();
                pq.add(p.freq);
            }
            //case2:
            // If no task is available, this second is idle.
            if(pq.isEmpty())
                continue;
            //case3:
            // Execute the most frequent task.
            int freq= pq.poll();
            freq--;
            // If more occurrences remain,
            // put the task into cooldown.
            if(freq>0)
            {
                q.offer(new Pair(freq, time+n+1));
            }
        }
        return time;

    }
}