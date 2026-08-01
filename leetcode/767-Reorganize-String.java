class Solution {

    class Pair
    {
        char ch;
        int freq;
        Pair(char ch, int freq)
        {
            this.ch=ch;
            this.freq= freq;
        }

    }
    public String reorganizeString(String s) {
        
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> b.freq-a.freq);

        StringBuilder ans= new StringBuilder();

        HashMap<Character, Integer> map= new HashMap<>();

        for(int i=0; i<s.length(); i++)
        {
            char ch= s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet())
        {
            char ch= entry.getKey();
            int freq= entry.getValue();
            Pair p= new Pair(ch, freq);
            pq.add(p);
        }

        Pair prev= null; //The character I just used

        while(!pq.isEmpty())
        {
            Pair curr= pq.poll(); //take out the max freq character
            ans.append(curr.ch);
            curr.freq--;

            if(prev != null && prev.freq>0)
            {
                pq.add(prev);
            }
            prev= curr;
        }
        
        if(prev != null && prev.freq>0)
            return "";
        else
            return ans.toString();

    }
}