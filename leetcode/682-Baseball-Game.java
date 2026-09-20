class Solution {
    public int calPoints(String[] operations) {
        int sum=0;
        Stack<Integer> stack= new Stack<>();

        for(int i=0; i<operations.length; i++)
        {
            //every element in array is string as seen in example having ""
            String op = operations[i];
            if(op.equals("+"))
            {
                int total = stack.get(stack.size()-1) + stack.get(stack.size()-2);
                stack.push(total);
            }
            else if( op.equals("D"))
            {
                int prev= stack.peek();
                stack.push(2*prev);
            }
            else if( op.equals("C"))
            {
               stack.pop();
            }
            else
            {
                int num= Integer.parseInt(op);
                stack.push(num);
            }
        }
        while(!stack.isEmpty())
        {
            int ele= stack.pop();
            sum+=ele;
        }
        return sum;
    }
}