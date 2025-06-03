import java.util.*;

public class Solution {
    
    public static int f(int i,int target,int arr[])
    {
        if(i==-1)
        {
            if(target==0) return 1;
            return 0;
        }
        
        int plus=f(i-1,target+arr[i],arr);
        int minus=f(i-1,target-arr[i],arr);
        return plus+minus;
    }
    
    
    public static int countValidExpressions(int[] arr, int target) {
        //Write your code here...
        int n=arr.length;
        return f(n-1,target,arr);
        
        
    }
}
