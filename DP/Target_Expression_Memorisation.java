import java.util.*;

public class Solution {
    
    public static int f(int i,int target,int arr[],int offset,int dp[][],int sum)
    {
        if(i==-1)
        {
            if(target==0) return 1;
            return 0;
        }
        if(Math.abs(target)>sum)
            return 0;
        
        if(dp[i][target+offset]!=-1)
            return dp[i][target+offset];
        
        
        int plus=f(i-1,target+arr[i],arr,offset,dp,sum);
        int minus=f(i-1,target-arr[i],arr,offset,dp,sum);
        return dp[i][target+offset]=plus+minus;
    }
    
    
    public static int countValidExpressions(int[] arr, int target) {
        //Write your code here...
        int n=arr.length;
        int sum=Arrays.stream(arr).sum();
        int offset=sum;
        if(Math.abs(target)>sum) return 0;
        
        int dp[][]=new int[n][2*sum+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        
        return f(n-1,target,arr,offset,dp,sum);
        
        
    }
}




// countValidExpressionsMemo(index, target, arr, dp, offset) {
//     /* Base Case: If index is -1, check if the target is zero */
//     if index == -1 {
//         if target == 0 {
//             return 1  /* Found a valid expression */
//         }    
//         return 0      /* No valid expression */
//     } 
    
//     /* Check if result for this state is already computed */
//     if dp[index][target + offset] != -1 {
//         return dp[index][target + offset]
//     } 
    
//     /* Recursive case: Explore adding '+' or '-' before the current element */
//     includeAsPlus = countValidExpressionsMemo(index - 1, target - arr[index], arr, dp, offset)
//     includeAsMinus = countValidExpressionsMemo(index - 1, target + arr[index], arr, dp, offset)

//     /* Store the result in the memoization table */
//     dp[index][target + offset] = includeAsPlus + includeAsMinus

//     /* Return the computed result */
//     return dp[index][target + offset]
// } 

// countValidExpressions(arr, target) {
//     /* Calculate the total sum of the array */
//     totalSum = sum(arr)

//     /* If the target is outside the range [-totalSum, totalSum], return 0 */
//     if abs(target) > totalSum {
//         return 0  /* Target is not achievable */
//     }

//     /* Offset to handle negative targets */
//     offset = totalSum

//     /* Initialize the DP table with -1 (uncomputed states) */
//     dp = initialize_2d_array(arr.size, 2 * totalSum + 1, -1)

//     /* Call the recursive helper function starting from the last index */
//     return countValidExpressionsMemo(arr.size() - 1, target, arr, dp, offset)
// }








