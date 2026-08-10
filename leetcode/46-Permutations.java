class Solution {
    public void generate(int[] nums,List<List<Integer>> result, List<Integer> current,  boolean used[])
    {
        //1.Base Case
        if(current.size()== nums.length)
        {
            result.add(new ArrayList<>(current));
            return;
        }
        // 3. Decide choices
        for(int i=0; i<nums.length; i++)
        {
            if(used[i])
                continue;
            // 4. MAKE
            current.add(nums[i]);
            used[i]= true;
            // RECURSE
            generate(nums, result, current, used);
            // UNDO / BACKTRACK
            current.remove(current.size()-1);
            used[i]= false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> current= new ArrayList<>();
        boolean used[]= new boolean[nums.length];

        generate(nums, result, current, used);
        return result;
    }
}