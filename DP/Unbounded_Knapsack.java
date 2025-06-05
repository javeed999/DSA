capacity = 4
profits = [10, 6, 1]
weights = [3, 2, 1]
ans:12

  capacity = 10
profits = [5, 11, 13]
weights = [2, 4, 6]
ans:27



import java.util.*;
 
public class Main {
    static int helper(int i, int capacity, int[] profits, int[] weights) {
        if (i == 0) return (capacity / weights[0]) * profits[0];
        else if (capacity == 0) return 0;
        int not_take = helper(i - 1, capacity, profits, weights);
        int take = 0;
        if (weights[i] <= capacity) take = profits[i] + helper(i, capacity - weights[i], profits, weights);
        return Math.max(take, not_take);
    }
 
    static int unboundedKnapsack(int[] weights, int[] profits, int capacity) {
        int n = weights.length;
        return helper(n - 1, capacity, profits, weights);
    }
/*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int[] profits = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) profits[i] = sc.nextInt();
        for (int i = 0; i < n;i++) weights[i] = sc.nextInt();
        System.out.println(unboundedKnapsack(weights, profits, capacity));
    }
*/
}

///
// Memorization
import java.util.*;

public class Main {
    static int helper(int i, int capacity, int[] profits, int[] weights, int[][] memo) {
        if (i == 0) return (capacity / weights[0]) * profits[0];
        else if (capacity == 0) return 0;
        if (memo[i][capacity] != -1) return memo[i][capacity];
        int notTake = helper(i - 1, capacity, profits, weights, memo);
        int take = 0;
        if (weights[i] <= capacity) {
            take = profits[i] + helper(i, capacity - weights[i], profits, weights, memo);
        }
        memo[i][capacity] = Math.max(take, notTake);
        return memo[i][capacity];
    }

    static int unboundedKnapsack(int[] weights, int[] profits, int capacity) {
        int n = weights.length;
        int[][] memo = new int[n][capacity + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return helper(n - 1, capacity, profits, weights, memo);
    }

/*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int[] profits = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) profits[i] = sc.nextInt();
        for (int i = 0; i < n; i++) weights[i] = sc.nextInt();
        System.out.println(unboundedKnapsack(weights, profits, capacity));
    }
*/
}

import java.util.*;

public class Main {
    public static int unboundedKnapsack(int[] weights, int[] profits, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n][capacity + 1];
        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = (j / weights[0]) * profits[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {
                int not_take = dp[i - 1][j];
                int take = 0;
                if (weights[i] <= j) {
                    take = profits[i] + dp[i][j - weights[i]];
                }
                dp[i][j] = Math.max(take, not_take);
            }
        }
        return dp[n - 1][capacity];
    }
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int[] profits = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) profits[i] = sc.nextInt();
        for (int i = 0; i < n; i++) weights[i] = sc.nextInt();
        System.out.println(knapsack(weights, profits, capacity));
    }
    */
}


// Single Array
import java.util.*;

public class Solution {
    
    // public static int f(int i,int weights[],int profits[],int capacity,int dp[][])
    // {
    //     if(i==0)
    //     {
    //         return (capacity/ weights[0])* profits[0];
    //     }
    //     if(dp[i][capacity]!=-1)
    //         return dp[i][capacity];
    //     int not_take=f(i-1,weights,profits,capacity,dp);
    //     int take=0;
    //     if(weights[i]<=capacity)
    //         take=profits[i]+f(i,weights,profits,capacity-weights[i],dp);
    // return dp[i][capacity]=Math.max(take,not_take);
    
    // }
    
  public int unboundedKnapsack(int[] weights, int[] profits, int capacity) {
        //Write Your Code Here...
        int n=weights.length;
        // int dp[][]=new int[n][capacity+1];
       int cur[]=new int[capacity+1];

        for(int j=0;j<=capacity;j++)

        {
            cur[j]=(j/weights[0])*profits[0];
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=capacity;j++)
            {
                int not_take=cur[j];
                int take=0;
                if(weights[i]<=j)
                    take=profits[i]+cur[j-weights[i]];
            cur[j]=Math.max(take,not_take);
                
            }
            // prev=cur.clone();
        }
        
        
        return cur[capacity];
        
        
    
        
    }
}
Complexity Analysis
Time Complexity: O(n × capacity)

The outer loop runs for n items, and the inner loop runs for capacity + 1. Hence, the overall complexity is proportional to n × capacity.
Space Complexity: O(capacity)

A single array cur of size capacity + 1 is used to store the maximum profit for each capacity, requiring O(capacity) space.



