class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0; i<32; i++) //an int in Java has 32 bits.
        {
            int count=0;
            for(int j=0; j<nums.length; j++)
            {
                if((nums[j] & (1 << i)) !=0) //check the i-th bit
                    count++;
            }
            if(count%3 !=0)
            {
                ans |= (1<<i);
            }
        }
        
        return ans;
    }
}