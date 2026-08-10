class Solution {
    public void generate(String digits, int idx, StringBuilder current, List<String> result)
    {
        //1.Base Case
        if(idx== digits.length())
        {
            result.add(current.toString());
            return;
        }
        // 2. Find choices for current digit
        String letters= "";
        switch(digits.charAt(idx))
        {
            case '2': letters = "abc"; break;
            case '3': letters = "def"; break;
            case '4': letters = "ghi"; break;
            case '5': letters = "jkl"; break;
            case '6': letters = "mno"; break;
            case '7': letters = "pqrs"; break;
            case '8': letters = "tuv"; break;
            case '9': letters = "wxyz"; break;
        }
        // 3. Try every choice
        for(int i=0; i< letters.length(); i++)
        {
            // MAKE
            current.append(letters.charAt(i));
            // RECURSE
            generate(digits, idx + 1, current, result);
            // UNDO / BACKTRACK
            current.deleteCharAt(current.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        int idx=0;
        StringBuilder current= new StringBuilder();
        List<String> result= new ArrayList<>();

        if(digits.length()==0)
        return result;

        generate(digits, idx, current, result);
        return result;
    }
}