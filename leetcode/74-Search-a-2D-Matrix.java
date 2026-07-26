class Solution {

    public int searchRow(int [][]matrix, int target)
    {
        int low=0, high= matrix.length-1, result=-1;;
        while(low<=high)
        {
            int guess= (low+high)/2;
            if(matrix[guess][0]<= target)
            {
                result= guess;
                low=guess+1;
            }
            else
                high=guess-1;
        }
        return result;
    }
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int row= searchRow(matrix, target);

        if(row==-1)
            return false;
        int low= 0;
        int high= matrix[0].length-1;
        int result=-1;

        while(low<=high)
        {
            int guess= (low+high)/2;
            if(matrix[row][guess]==target)
                return true;
            else if(matrix[row][guess]>target)
                high= guess-1; 
            else
                low= guess+1;
        }
        return false;
        
    }
}