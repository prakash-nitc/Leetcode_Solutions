class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap <Character, Integer> need= new HashMap<>();
        HashMap <Character, Integer> have= new HashMap<>();
        int result=Integer.MAX_VALUE;

        for(int i=0; i<text.length();i++)
        {
            char ch= text.charAt(i);
            have.put(ch, have.getOrDefault(ch,0)+1);
        }

        need.put('b',1);
        need.put('a',1);
        need.put('l',2);
        need.put('o',2);
        need.put('n',1);

        for(Map.Entry<Character, Integer> entry: need.entrySet())
        {
            char ch= entry.getKey();
            int required= entry.getValue();
            int available= have.getOrDefault(ch,0);

            int freq= available/required;
            result= Math.min(result, freq);
        }
        return result;
    }
}