class Solution {
    public String removeDuplicates(String s) {
        
        Stack <Character> stack= new Stack<>();

        for(int i=0; i< s.length(); i++)
        {
            char ch= s.charAt(i);

            if(stack.isEmpty()==false && stack.peek()== ch )
            {
                stack.pop();
            }
            else
            {
                stack.push(ch);
            }
        }

        StringBuilder ans= new StringBuilder();
        
        while(stack.isEmpty()== false)
        {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}