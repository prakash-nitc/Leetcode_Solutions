1class Solution {
2    public int totalFruit(int[] fruits) {
3        int low=0, high=0;
4        int n= fruits.length;
5        int maxlen=-1;
6
7        HashMap <Integer, Integer> map = new HashMap<>();
8
9        for(high=0; high<n; high++)
10        {
11            map.put(fruits[high], map.getOrDefault(fruits[high],0)+1);
12
13            while(map.size()>2)
14            {
15                map.put(fruits[low], map.get(fruits[low])-1);
16
17                if(map.get(fruits[low])==0)
18                    map.remove(fruits[low]);
19
20                low++;
21            }
22
23            maxlen= Math.max(maxlen, high-low+1);
24        }
25        return maxlen;
26    }
27}