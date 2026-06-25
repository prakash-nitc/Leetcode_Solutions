1class Solution {
2    public int squaresum(int n)
3    {
4        int sum=0;
5        while(n>0)
6        {
7            int d= n%10;
8            sum+= d*d;
9            n=n/10;
10        }
11        return sum;
12    }
13    public boolean isHappy(int n) {
14        int slow= n, fast=n;
15
16        while(fast!=1)
17        {
18            slow= squaresum(slow);
19            fast= squaresum(fast);
20            fast= squaresum(fast);
21
22            if(slow == fast && slow!= 1)
23            {
24                return false;
25            }
26        }
27        return true;
28    }
29}