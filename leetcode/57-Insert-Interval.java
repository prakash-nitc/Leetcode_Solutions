class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        //Insert Interval
        List<int[]> result= new ArrayList<>();
        boolean isInserted = false;

        for(int i=0; i<intervals.length; i++)
        {
            if(!isInserted && intervals[i][0]>= newInterval[0])
            { //newInterval[0] bcz is its a 1D array
            //not newinterval[i][0] bcz its a list not array(line14)
            //It stores int[], not integers
                result.add(newInterval);
                isInserted= true;
            }
            result.add(intervals[i]);// add curr variable
        }
        if(isInserted== false)
        {
            result.add(newInterval);
        }

        //MergeInterval
        List<int[]> mergearr= new ArrayList<>();
        //result is a List, not an array, so we use get
        int start1= result.get(0)[0];
        int end1= result.get(0)[1];

        for(int i=1; i<result.size(); i++)
        {
            int start2= result.get(i)[0];
            int end2= result.get(i)[1];

            if(end1>=start2)
            {
                end1= Math.max(end1, end2);
            }
            else
            {
                mergearr.add(new int[]{start1, end1});
                start1= start2;
                end1= end2;
            }
        }
        mergearr.add(new int[]{start1,end1});
        return mergearr.toArray(new int[mergearr.size()][]);
    }
}