1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int high=0,low=0;
4        int maxlen= Integer.MIN_VALUE;
5        int n= s.length();
6        HashMap <Character, Integer> map= new HashMap<>();
7
8        for(high=0; high<n; high++)
9        {
10            char ch=s.charAt(high);
11            map.put(ch, map.getOrDefault(ch,0)+1);
12            int k = high-low+1;
13
14            while(map.size()< k)
15            {
16                char leftchar = s.charAt(low);
17                map.put(leftchar, map.get(leftchar)-1);
18
19                if(map.get(leftchar)==0)
20                    map.remove(leftchar);
21                low++;
22
23                k= high-low+1;
24            }
25
26            maxlen= Math.max(maxlen, k);
27
28        }
29        if(maxlen== Integer.MIN_VALUE)
30        return 0;
31        else
32        return maxlen;
33    }
34}