1class Solution {
2    public int[] sortedSquares(int[] nums) {
3       int n= nums.length;
4       int result[] = new int[n];
5       int left=0, right=n-1;
6
7       for (int pos= n-1; pos>=0; pos--)
8       {
9        int leftsquare = nums[left]*nums[left];
10        int rightsquare = nums[right]*nums[right];
11        if (leftsquare > rightsquare)
12        {
13            result[pos]= leftsquare;
14            left++;
15        }
16        else
17        {
18            result[pos] = rightsquare;
19            right--;
20        }
21       }
22       return result;
23    }
24}
25