class Solution {
    public int searchRow(int[][] matrix, int target) 
    {
        int low=0, high=matrix.length-1, result=-1;
        while(low<=high)
        {
            int mid= (low+high)/2;
            if(matrix[mid][0]<=target)
            {
                result= mid;
                low= mid+1;
            }
            else
                high= mid-1;
        }
        return result;
    }
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int row= searchRow(matrix, target);
        if(row==-1)
            return false;
        int low=0, high= matrix[0].length-1;

        while(low<=high)
        {
            int mid= (low+high)/2;
            if(matrix[row][mid]==target)
                return true;
            else if(matrix[row][mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return false;
    }
}