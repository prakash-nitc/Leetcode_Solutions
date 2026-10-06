class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low=0, high=0, maxlen=0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(high=0; high<s.length(); high++ )
        {
            char ch= s.charAt(high);
            map.put(ch, map.getOrDefault(ch,0)+1);
            
            while(map.size()< (high-low+1))
            {
                char leftchar= s.charAt(low);
                map.put(leftchar, map.get(leftchar)-1);

                if(map.get(leftchar)==0)
                    map.remove(leftchar);
                low++;

            }

            maxlen= Math.max(maxlen, high-low+1);
        }
        return maxlen;
    }
}