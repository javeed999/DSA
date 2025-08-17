int arr[]= {3,1,2,5,3};
		int n=arr.length;
	    long sn=(n*(n+1))/2;
        long s2n=( n * (n+1)* (2*n+1))/6;
	    long s=0,s2=0;
	    for(long num:arr)
	    {
	        s+=num;
	        s2+=num*num;
	    }
	     long val1=s-sn; // x-y
	     long val2=s2-s2n; //x2-y2
	     val2=val2/val1;
	     
	     long dup=(val1+val2)/2;
	     long mis=val2-dup;
	     
	     
	     
	    System.out.println(dup+" "+mis);







/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
        int arr[]= {3,1,2,5,3};
        int n=arr.length;
        HashSet<Integer>set=new HashSet<>();
        int max=0,dup=0;
        for(int num:arr)
        {   
            if(set.contains(num))
                dup=num;
            else 
                  set.add(num);
            max=Math.max(max,num);
        }
                   System.out.println("Duplicate number is "+" "+dup);

       int zor=0;
        for(int num:set)
        {
            zor=zor^num;
        }
        if(zor==0) System.out.println("missing number is "+" "+(max+1));
        else 
        {
            int rem=max%4,xor=-1;
            if(rem==0) xor=max; 
            else if(rem==1) xor=1;
            else if(rem==2) xor=max+1;
            else xor=0;
            zor=zor^xor;
            System.out.println("missing number is "+" "+zor);
        }
        

	}
}





/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4, 6, 7, 5};
        int xor=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            xor^=arr[i];
            xor^=(i+1);
        }
        
        int bitNo=0;
        while(true)
        {
            if( (xor & (1<< bitNo)) !=0)
                break;
            bitNo++;
        }
        
        int one=0,zero=0;
        
        for(int i=0;i<n;i++)
        {
            if((arr[i] & (1<<bitNo) )!=0)
                one=one^arr[i];
            else 
                zero=zero^ arr[i];
        }
        
        
        for(int i=1;i<=n;i++)
        {
            if((i & (1<<bitNo) )!=0)
                one=one^i;
            else 
                zero=zero^i;
        }
        
        
        
        System.out.println(one+" "+zero);
        
        
	}
}









