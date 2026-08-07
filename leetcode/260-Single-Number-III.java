class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i=0; i<nums.length; i++)
        {
            xor^= nums[i]; //xor = unique1 ^ unique2 after this loop
        }

        int mask= xor&(-xor);
        int a=0;
        int b=0;

        for(int i=0; i<nums.length; i++)
        {
            if((nums[i]& mask)==0)
                a^= nums[i];
            else
                b^= nums[i];
        }
        return new int[]{a,b};
    }
}