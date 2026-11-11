class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0, right= nums.length-1, pos= nums.length-1;
        int result[]= new int[nums.length];
        while(left<=right)
        {
            int leftsq= nums[left]*nums[left];
            int rightsq= nums[right]*nums[right];

            if(leftsq< rightsq)
            {
                result[pos--]= rightsq;
                right--;
            }
                
            else
            {
                result[pos--]= leftsq;
                left++;
            }
        }
        return result;
    
        
    }
}