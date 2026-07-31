class Solution {

    class Pair
    {
        String str;
        int freq;
        Pair(String str, int freq)
        {
            this.str= str;
            this.freq= freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue <Pair> pq= new PriorityQueue<>((a,b)->
        {
            if(a.freq != b.freq)
            {
                return a.freq-b.freq;
            }
            else
            {
                return b.str.compareTo(a.str);
            }
        });

        HashMap <String, Integer> map= new HashMap<>();

        for(int i=0; i<words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            String str= entry.getKey();
            int freq= entry.getValue();

            Pair current= new Pair(str, freq);

            if(pq.size()<k)
            {
                pq.add(current);
            }
            else
            {
                if(current.freq> pq.peek().freq || current.freq == pq.peek().freq && (current.str.compareTo(pq.peek().str)<0))
                {
                    pq.poll();
                    pq.add(current);
                }
            }
        }

        ArrayList<String> ans= new ArrayList<>();
        for(int i=0; i<k; i++)
        {
            ans.add(pq.poll().str);
        }
        Collections.reverse(ans);
        return ans;
        
    }
}