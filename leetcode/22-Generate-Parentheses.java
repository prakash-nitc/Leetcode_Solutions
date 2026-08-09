class Solution {
    public List<String> generateParenthesis(int n) {

        ArrayList<String> result= new ArrayList<>();
        StringBuilder current= new StringBuilder();
        int open=0, close=0;
        generate(current, open, close, n, result);
        return result;    
    }

    public void generate(StringBuilder current, int open, int close, int n, List<String> result)
    {
        //Base Case
        if(current.length()== 2*n)
        {
            result.add(current.toString());
            return;
        }
        // Choice 1: Add '('
        if(open<n)
        {
            current.append('(');
            generate(current, open+1, close, n, result);
            //backtrack
            current.deleteCharAt(current.length()-1);
        }
        // Choice 2: Add ')'
        if(close<open)
        {
            current.append(')');
            generate(current, open, close+1, n, result);
            //backtrack
            current.deleteCharAt(current.length()-1);

        }

    }
}