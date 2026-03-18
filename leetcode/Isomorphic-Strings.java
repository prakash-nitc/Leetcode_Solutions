1class Solution {
2    public boolean isIsomorphic(String s, String t) {
3        if( s.length() != t.length())
4            return false;
5
6        Map <Character, Character> mapST = new HashMap<>();
7        Map <Character, Character> mapTS = new HashMap<>();
8
9
10        for(int i=0; i<s.length(); i++)
11        {
12            char c1= s.charAt(i);
13            char c2= t.charAt(i);
14
15            if(mapST.containsKey(c1))
16            {
17                if(mapST.get(c1)!=c2)
18                   return false;
19            }
20            else
21                mapST.put(c1,c2);
22
23             if(mapTS.containsKey(c2))
24            {
25                if(mapTS.get(c2)!=c1)
26                    return false;
27            }
28            else
29                mapTS.put(c2,c1);
30        }
31        return true;
32    }
33}
34