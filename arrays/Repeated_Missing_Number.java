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
