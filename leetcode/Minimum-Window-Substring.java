1class Solution {
2    public String minWindow(String s, String t) {
3        
4        int need[] = new int[256];
5        for( int i=0; i<t.length(); i++)
6        {
7            need[t.charAt(i)]++;
8        }
9
10        int window[] = new int[256];
11        int low=0,high=0;
12        int matched=0;
13        int minlength= Integer.MAX_VALUE;
14        int n= s.length();
15        int start=0;
16
17        for(high=0; high<n; high++)
18        {
19            char ch= s.charAt(high);
20            window[ch]++;
21
22            if(window[ch] <= need[ch])
23            {
24                matched++;
25            }
26
27            while(matched == t.length())
28            {
29                int length = high-low+1;
30                if (length < minlength) 
31                {
32                    minlength = length;
33                    start = low;
34                }
35
36                char leftchar = s.charAt(low);
37                window[leftchar]--;
38
39                if(window[leftchar]< need[leftchar])
40                {
41                    matched--;
42                }
43                low++;
44            }
45        }
46        if (minlength == Integer.MAX_VALUE)
47            {
48                return "";
49            }
50        return s.substring(start, start+minlength);
51    }
52}