class Solution {

    public int noOfSmallerElements(int [][]matrix,int n, int m, int guess)
    {
        int row= n-1, col=0, count=0;

        while(row>=0 && col<= m-1)
        {
            if(matrix[row][col]<=guess)
            {
                count+= row+1;
                col++;
            }
            else
                row--;
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) 
    {
        int total_row= matrix.length;
        int total_col= matrix[0].length;
        int low= matrix[0][0];
        int high= matrix[total_row-1][total_col-1];
        int result=-1;

        while(low<=high)
        {
            int guess= (low+high)/2;
            int ans= noOfSmallerElements(matrix,total_row, total_col, guess);

            if(ans<k)
                low=guess+1;
            else
            {
                result= guess;
                high= guess-1;
            }
        }
        return result;
    }
}