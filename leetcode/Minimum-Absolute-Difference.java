1import java.util.*;
2class Solution {
3    public List<List<Integer>> minimumAbsDifference(int[] arr) {
4        Arrays.sort(arr);
5
6        List<List<Integer>> result = new ArrayList<>();
7
8        int n= arr.length;
9        int minDiff =Integer.MAX_VALUE;
10
11        for(int i=1;i<n;i++)
12        {
13            int diff = arr[i]- arr[i-1];
14
15            if(diff < minDiff)
16            {
17                minDiff= diff;
18                result.clear();
19                result.add(Arrays.asList(arr[i-1], arr[i]));
20            }
21            else if (diff == minDiff)
22            {
23                result.add(Arrays.asList(arr[i-1],arr[i]));
24            }
25        }
26        return result;
27    }
28}