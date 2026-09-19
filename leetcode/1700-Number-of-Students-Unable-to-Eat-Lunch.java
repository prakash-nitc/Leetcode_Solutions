class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count_students0= 0;
        int count_students1= 0;

        for(int i=0; i<students.length; i++)
        {
            if(students[i]==0)
                count_students0++;
            else
                count_students1++;
        }
        for(int i=0; i<sandwiches.length; i++)
        {
            //The sandwich can be either 0 or 1
            if(sandwiches[i]==0 )
            {
                if(count_students0>0)
                    count_students0--;
                else
                    break;
            }
            else
            {
                if (count_students1>0)
                    count_students1--;
                else
                    break;
            }

        }
        int result= count_students0 + count_students1;
        return result;
    }
}