class Solution {
    public void generate(String digits, int idx, StringBuilder current, List<String> result, Map<Character, String> map)
    {
        //1.Base Case
        if(idx== digits.length())
        {
            result.add(current.toString());
            return;
        }
        // 2. Find choices for current digit
        String letters= map.get(digits.charAt(idx));
        
        // 3. Try every choice
        for(int i=0; i< letters.length(); i++)
        {
            // MAKE
            current.append(letters.charAt(i));
            // RECURSE
            generate(digits, idx + 1, current, result, map);
            // UNDO / BACKTRACK
            current.deleteCharAt(current.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        int idx=0;
        StringBuilder current= new StringBuilder();
        List<String> result= new ArrayList<>();
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if(digits.length()==0)
        return result;

        generate(digits, idx, current, result, map);
        return result;
    }
}