class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        int res[]= new int[m*n];
        int k=0;
        
        for(int d=0; d<= m+n-2; d++)
        {
            int minrow= Math.max(0,d-n+1);
            int maxrow= Math.min(d, m-1);

            if(d%2==0)
            {
                for(int row=maxrow; row>=minrow; row--)
                {
                    int col= d- row;
                    res[k++]= mat[row][col];
                }
            }
            else
            {
                for(int row= minrow; row<=maxrow; row++)
                {
                    int col= d- row;
                    res[k++]= mat[row][col];
                }
            }
        }
        return res;
    }
}