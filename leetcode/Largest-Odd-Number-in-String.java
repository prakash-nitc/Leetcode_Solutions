1class Solution {
2    public String largestOddNumber(String s) {
3        int len= s.length();
4        String st="";
5        int j=-1;
6
7        for(int i=len-1;i>=0;i--) 
8        {
9            if((s.charAt(i)-'0')%2==1)
10            {
11                j=i;
12                break;
13            }
14        }
15
16        if(j==-1)
17        return "";
18
19        int i=0;
20        while(i<len)
21        {
22            if(s.charAt(i)!='0')
23            {
24                break;
25            }
26            i++;
27        }
28        return s.substring(i,j+1);
29    }
30}