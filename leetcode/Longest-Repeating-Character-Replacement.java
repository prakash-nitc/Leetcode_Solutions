1class Solution {
2    public int characterReplacement(String s, int k) {
3        int freq[] = new int[26];
4
5        int low=0,high=0;
6        int length=0,diff=0;
7        int maxfreq= 0;
8        int result=0;
9        int n= s.length();
10
11        for(high=0; high<n; high++)
12        {
13            char ch = s.charAt(high);
14            freq[ch- 'A']++;
15
16            maxfreq= Math.max(maxfreq, freq[ch-'A']);
17            length= high-low+1;
18            diff = length-maxfreq;
19
20            while(diff>k)
21            {
22                char leftchar= s.charAt(low);
23                freq[leftchar-'A']--;
24                low++;
25                length= high-low+1;
26                diff = length-maxfreq;
27            }
28            length= high-low+1;
29            result= Math.max(result, length);
30
31        }
32        return result;
33    }
34}