class Solution {
    public double power(double x, long n)
    {
        if(n==0) return 1;
        double half= power(x, n/2); //getting runtime error for n=-200000000, so halving it

        if(n%2==0)
            return half*half;
        else
            return half*half*x;

    }
    public double myPow(double x, int n) {

        long N= n;
        if(N<1)
            return 1/ power(x, -N);
        else
            return power(x, N);
           
    }
}