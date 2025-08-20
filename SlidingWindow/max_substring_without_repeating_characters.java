class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int ans=Integer.MIN_VALUE;
        
        int n=s.length();
        if(n==0) return 0;
        if(n==1) return 1; 
        // for(int i=0;i<n;i++)
        // {
        //     HashSet<Character> set=new HashSet<>();
        //     for(int j=i;j<n;j++)
        //     {
        //         char ch=s.charAt(j);
        //         if(set.contains(ch))
        //         {
        //             ans=Math.max(ans,j-i);
        //             break;
        //         }

        //         set.add(ch);
        //     ans=Math.max(ans,j-i+1);

        //     }
            
        // }
        //
        // int left=0;
        // HashSet<Character> set=new HashSet<>();
        // for(int right=0;right<n;right++)
        // {
        //     while(set.contains(s.charAt(right)))
        //     {
        //         set.remove(s.charAt(left));
        //         left++;
        //     }
        //     set.add(s.charAt(right));
        //     ans=Math.max(ans,right-left+1);
        // }
        //
        int left=0;
        int ans=0;
        HashMap<Character,Integer>map=new HashMap<>();
        for(int right=0;right<n;right++)
        {
            if(map.containsKey(s.charAt(right)))
            {
                left=Math.max(left,map.get(s.charAt(right))+1);
            }
                map.put(s.charAt(right),right);

            ans=Math.max(ans,right-left+1);
        }


        return ans;
    }
}
