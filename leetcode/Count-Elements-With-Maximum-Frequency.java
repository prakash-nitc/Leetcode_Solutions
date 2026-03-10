1class Solution {
2    public int maxFrequencyElements(int[] nums) {
3        int n= nums.length;
4     int maxfreq=0;
5     int sum=0;
6
7     boolean visited[] = new boolean[n];
8
9     for(int i=0;i<n;i++)
10     {
11        if(visited[i])
12        continue; 
13        
14        int freq=0;
15
16        for(int j=i; j<n; j++)
17        {
18            if(nums[i]==nums[j])
19            {
20                freq++;
21                visited[j]= true;
22            }
23        }
24
25        if(freq>maxfreq)
26        {
27            maxfreq= freq;
28            sum=freq;
29        }
30        else if(freq==maxfreq)
31        {
32           sum= sum+ freq;
33        }
34     }
35     return sum;
36    }
37}