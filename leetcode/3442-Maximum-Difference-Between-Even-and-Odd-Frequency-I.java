class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        int maxOdd= 0;
        int minEven= Integer.MAX_VALUE;

        for(int i=0; i<s.length(); i++)
        {
            char ch= s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet())
        {
            char ch= entry.getKey();
            int freq= entry.getValue();

            if(freq%2==0)
                minEven= Math.min(minEven, freq);
            else
                maxOdd= Math.max(maxOdd, freq);

        }
        return maxOdd-minEven;
    }
}