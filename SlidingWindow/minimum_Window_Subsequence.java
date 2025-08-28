class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        // int minLen=Integer.MAX_VALUE,n=s1.length(),m=s2.length();
        // int startIndex=-1;
        // for(int i=0;i<n;i++)
        // {
        //   for(int j=i;j<n;j++)
        //   {
        //         if(s1.charAt(j)==s2.charAt(0))
        //     {
        //         int p1=i,p2=0;
        //         while(p1<n && p2<m)
        //         {
        //             if(s1.charAt(p1)==s2.charAt(p2))
        //                 p2++;
        //         p1++;

        //         }
            
        //     if(p2==m)
        //     {
        //       if(p1-i<minLen)
        //       {
        //           minLen=p1-i;
        //           startIndex=i;
        //       }
        //       break;
        //     }
            
        //     }
        //   }
        // }
        // return startIndex==-1 ? "" :s1.substring(startIndex,startIndex+minLen); 
        
        
        
        int n=s1.length(),m=s2.length();
        int minLen=Integer.MAX_VALUE,startIndex=-1;
        for(int i=0;i<n;i++)
        {
            if(s1.charAt(i)==s2.charAt(0))
            {
                int p1=i,p2=0;
                while(p1<n && p2<m)
                {
                    if(s1.charAt(p1)==s2.charAt(p2))
                        p2++;
                    p1++;
                }
                
                if(p2==m)
                {
                    int end=p1;
                    p2=p2-1;
                    while(p1>i && p2>=0)
                    {
                        if(s1.charAt(p1-1)==s2.charAt(p2))
                            p2--;
                        p1--;
                    }
                    if(end-p1<minLen)
                    {
                        minLen=end-p1;
                        startIndex=p1;
                    }
                }
            }
        }
        
        
        return startIndex==-1 ? "" : s1.substring(startIndex,startIndex+minLen);
        
        
        
        
        
        
    }
}
