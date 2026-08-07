class Solution {
    public int getSum(int a, int b) {
        while(b!= 0) //iterate until carry is zero
        {
            int sum= a ^ b;
            int carry= (a & b)<< 1;

            a= sum;
            b= carry;
        }
        return a;
    }
}