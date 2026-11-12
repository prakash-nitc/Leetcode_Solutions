class Solution {
    public boolean backspaceCompare(String s, String t) {
        int right1= s.length()-1;
        int right2= t.length()-1;
        int f=0, skip1=0, skip2=0;

        while (true)
        {
        
            while (right1 >= 0) 
            {
                if (s.charAt(right1) == '#') 
                {
                    skip1++;
                    right1--;
                } 
                else if (skip1 > 0) 
                {
                    skip1--;
                    right1--;
                } 
                else 
                {
                    break; // Found a valid character
                }
            }
            while(right2>=0)
            {   //for c2
            
                if(t.charAt(right2)=='#')
                {
                    skip2++;
                    right2--;
                }
                else if(skip2>0)
                {
                    skip2--;
                    right2--;
                }
                else 
                {
                    break; // Found a valid character
                }
                    
            }

            if(right1==-1 && right2==-1)
                return true;
            else if(right1==-1 || right2==-1)
                return false;
            else if(s.charAt(right1)!=t.charAt(right2))
                return false;
            else
            {
                right1--;
                right2--;
            }

        }
        
    }
}