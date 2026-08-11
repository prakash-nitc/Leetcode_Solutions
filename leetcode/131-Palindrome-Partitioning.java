class Solution {
    boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
    void generate(String s,int idx,List<String> current,List<List<String>> result)
    {
        // Base case
        if (idx == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Try every possible ending position
        for(int end= idx; end< s.length(); end++)
        {
            if(isPalindrome(s,idx,end))
            {
                // MAKE
                current.add(s.substring(idx, end+1));
                // RECURSE
                generate(s, end+1, current, result);
                // UNDO / BACKTRACK
                current.remove(current.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        int idx=0;

        generate(s, idx, current, result);

        return result;
    }
}