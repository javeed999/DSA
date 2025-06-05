Problem Statement
You own a carpentry shop and have a wooden plank of length n units. Customers pay different prices for planks of specific lengths.

The price of a plank of length i is given in the array arr[] of length n + 1, where arr[i] denotes the price for a plank of length i. 

Note that arr[0] is always 0, indicating that a plank of length 0 has no value.

Your goal is to maximize your profit by cutting the plank into smaller pieces and selling them.

n = 8
arr = [0, 2, 6, 9, 10, 11, 18, 18, 21]
ans:24
  Recursive Approach
Start by setting up the size of the array and initializing the answer to zero.

Use recursion to explore all possible wood cuts from length 1 to the current length.

For each cut length, calculate the value of the remaining piece recursively.

Compare the current cut's value with the maximum value found so far.

Update the maximum value by considering all possible cut lengths.

Return the maximum value for the given wood length.

import java.util.*;

public class Main {

    public static int helperFunction(int i, int[] arr) {
        if (i == 0) return 0;                                          // Base case: No wood left to cut
        
        int ans = 0;
        for (int j = 1; j <= i; j++) {
            ans = Math.max(ans, arr[j] + helperFunction(i - j, arr));  // Try all possible cuts and maximize the value
        }
        
        return ans;
    }

    public static int woodCutting(int[] arr) {
        int n = arr.length - 1;
        return helperFunction(n, arr);                                 // Start recursion from the last piece of wood
    }


Tabulation Approach
Initialize a dynamic programming table to store the maximum values for each wood length.

Iterate through each possible wood length from 1 to the total length.

For each wood length, check all smaller segment lengths to find the best way to cut.

Calculate the value by combining the segment's value and the previously calculated maximum.

Store the maximum value obtained for the current length in the table.

Return the maximum value for the full wood length as the result.


public class Main {

    public static int woodCutting(int[] arr) {
        int n = arr.length - 1;
        int[] dp = new int[n + 1]; // Initialize dp array to store max values

        for (int i = 1; i <= n; i++) {
            int maxi = 0;
            for (int len = 1; len <= i; len++) {
                // Update maxi by considering the value of cutting the wood into 'len' and the remaining part
                maxi = Math.max(maxi, arr[len] + dp[i - len]);
            }
            dp[i] = maxi; // Store the max value for the current wood length
        }

        return dp[n]; 
    }
Complexity Analysis
Time Complexity: O(n^2)  

n is the length of the wood (size of arr minus one).

The outer loop iterates through all possible wood lengths from 1 to n.

The inner loop checks all possible segment lengths for each wood length, resulting in n * n iterations.

Therefore, the time complexity is O(n^2).

Space Complexity: O(n)  

A 1D array dp of size n + 1 is used to store the maximum values for each wood length.

The space complexity is O(n) due to this additional storage.

  
  
