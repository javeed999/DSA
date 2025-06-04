// class Solution {
//     public int f(int i, int[] coins, int amount, int[][] dp) {
//         if (i == 0) {
//             if (amount % coins[0] == 0)
//                 return amount / coins[0];
//             else
//                 return (int)1e9; // large value to represent impossible case
//         }

//         if (dp[i][amount] != -1) return dp[i][amount];

//         int notTake = f(i - 1, coins, amount, dp);
//         int take = (int)1e9;
//         if (coins[i] <= amount)
//             take = 1 + f(i, coins, amount - coins[i], dp);

//         return dp[i][amount] = Math.min(take, notTake);
//     }

//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];
//         for (int[] row : dp) Arrays.fill(row, -1);

//         int res = f(n - 1, coins, amount, dp);
//         return res >= (int)1e9 ? -1 : res;
//     }
// }

class Solution {
    

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int j=0;j<=amount;j++)
        {
            if(j%coins[0]==0)
                dp[0][j]=j/coins[0];
            else 
                dp[0][j]=(int)(1e9);
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                int not_take=dp[i-1][j];
                int take=(int)(1e9);
                if(coins[i]<=j)
                    take=1+dp[i][j-coins[i]];
                dp[i][j]=Math.min(take,not_take);
            }
        }


        int res = dp[n-1][amount];
        return res >= (int)(1e9) ? -1 : res;
    }
}

