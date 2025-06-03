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
