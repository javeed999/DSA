// class Solution {
//     public static int f(int i,int arr[],int target ,int dp[][])
//     {
//         if(i==0)
//         {
//             if(target % arr[i]==0)
//                 return 1;
//             return 0;
//         }
//         if(dp[i][target]!=-1)
//             return dp[i][target];
//         int not_take=f(i-1,arr,target,dp);
//         int take=0;
//         if(arr[i]<=target)
//         {
//             take=f(i,arr,target-arr[i],dp);
//         }
//         return dp[i][target]=take+not_take;

//     }
//     public int change(int amount, int[] coins) {
//         int n=coins.length;
//         int dp[][]=new int[n][amount+1];
//         for(int i=0;i<n;i++)
//             Arrays.fill(dp[i],-1);
//         return f(n-1,coins,amount,dp);
//     }
// }


class Solution {
    
    public int change(int amount, int[] coins) {
        int n=coins.length;
        // int dp[][]=new int[n][amount+1];
        int prev[]=new int[amount+1];
        int cur[]=new int[amount+1];
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
                prev[i]=1;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                int not_take=prev[j];
                int take=0;
                if(coins[i]<=j)
                    take=cur[j-coins[i]];
            
                cur[j]=take+not_take;
            }
            prev=cur.clone();
        }
        return prev[amount];
    }
}
