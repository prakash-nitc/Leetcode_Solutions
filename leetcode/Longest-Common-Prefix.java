1class Solution {
2    public String longestCommonPrefix(String[] str) {
3       int n= str.length;
4        Arrays.sort(str);
5
6        String first = str[0];
7        String last = str[n-1];
8        String ans="";
9
10        for(int i=0; i<Math.min(first.length(), last.length()); i++)
11        {
12            if(first.charAt(i) != last.charAt(i))
13            {
14                break;
15            }
16            else
17            {
18                ans= ans + first.charAt(i);
19            }
20        }
21        return ans;
22    }
23}
24