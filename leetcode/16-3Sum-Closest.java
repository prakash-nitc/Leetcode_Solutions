class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int bestsum= nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++)
        {
            int left= i+1, right= nums.length-1;
            while(left<right)
            {
                int sum= nums[i]+ nums[left]+nums[right];
                if(sum==target)
                    return sum;
                else if(sum<target)
                {
                    if(Math.abs(target-sum)<Math.abs(target-bestsum))
                        bestsum=sum;
                    left++;
                }
                else
                {
                    if(Math.abs(target-sum)<Math.abs(target-bestsum))
                        bestsum=sum;
                    right--;
                }

            }
        }
        return bestsum;
    }
}