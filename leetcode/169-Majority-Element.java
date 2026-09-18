class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int k= nums.length/2;
        for(int i=0; i<nums.length; i++)
        {
            if(map.get(nums[i])>k)
                return nums[i];
        }
        return -1;
    }
}