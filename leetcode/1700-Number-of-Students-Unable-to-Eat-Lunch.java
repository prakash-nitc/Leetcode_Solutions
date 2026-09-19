class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue= new LinkedList<>();
        Stack<Integer> stack= new Stack<>();

        //populate students
        for(int i=0; i< students.length; i++)
        {
            queue.add(students[i]);
        }
        //populate stack in reverse from R->L as we need 1st ele as top
        for(int i= sandwiches.length-1; i>=0; i--)
        {
            stack.push(sandwiches[i]);
        }

        int rejected=0;
        while(queue.size()!= rejected)
        {
            int student= queue.peek();
            int sandwich= stack.peek();

            if(student== sandwich)
            {
                queue.poll();
                stack.pop();
                rejected=0;
            }
            else
            {
                queue.poll();
                queue.add(student);
                rejected++;
            }
        }
        return queue.size();

    }
}