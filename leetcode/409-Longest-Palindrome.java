class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        int longest=0;
        boolean odd_flag= false;

        for(int i=0; i<s.length();i++)
        {
            char ch= s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet())
        {
            int value= entry.getValue();
            if(value%2==0)
                longest+= value;
            else
            {
                odd_flag= true;
                longest+= value-1;
            }
                
        }

        if(odd_flag== false)
            return longest;
        else
            return longest+1;
    }
}