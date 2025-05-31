// class Solution {
//     public int candy(int[] ratings) {
//         int n=ratings.length;
//         int left[]=new int[n];
//         int right[]=new int[n];
//         Arrays.fill(left,1);
//         Arrays.fill(right,1);
//         for(int i=1;i<n;i++)
//         {
//             if(ratings[i]>ratings[i-1])
//             {
//                 left[i]=left[i-1]+1;
//             }
//             else 
//                 left[i]=1;
//         }

//         int prev=1,cur=0;
//         int ans=Math.max(left[n-1],1);
//         for(int i=n-2;i>=0;i--)
//         {
//             if(ratings[i]>ratings[i+1])
//             {
//                 cur=prev+1;
//             }
//             else 
//                 cur=1;
//             ans+=Math.max(left[i],cur);
//             prev=cur;
//         }
//         // return ans;




//         // for(int i=n-2;i>=0;i--)
//         // {
//         //     if(ratings[i]>ratings[i+1])
//         //         right[i]=right[i+1]+1;
//         //     else 
//         //         right[i]=1;
//         // }
        

//         return ans;
//     }
// }

class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int i=1,ans=1;
        while(i<n)
        {
            if(ratings[i]==ratings[i-1])
            {
                ans+=1;
                i++;
                continue;
            }
            int top=1;
            while(i<n && ratings[i]>ratings[i-1])
            {
                top++;
                ans+=top;
                i++;
            }

            int bottom=1;
            while(i<n && ratings[i]<ratings[i-1])
            {
                ans+=bottom;
                bottom++;
                i++;
            }
            if(bottom>top)
            {
                ans+=bottom-top;
            }
        }
        return ans;
    }
}
