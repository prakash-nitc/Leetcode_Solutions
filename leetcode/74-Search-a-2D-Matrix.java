class Solution {

    public boolean searchMatrix(int[][] matrix, int target)
    {
        int low=0;
        int no_of_rows= matrix.length, no_of_cols= matrix[0].length;
        int high= no_of_rows*no_of_cols-1;

        while(low<=high)
        {
            int guess=(low+high)/2;

            int row_number= guess/no_of_cols;
            int col_number= guess%no_of_cols;

            if(matrix[row_number][col_number]==target)
                return true;
            else if (matrix[row_number][col_number]<target)
                low= guess+1;
            else
                high=guess-1;
        }
        return false;
        
    }
}