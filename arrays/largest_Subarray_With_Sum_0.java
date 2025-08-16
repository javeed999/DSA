/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
        int nums[]={6, -2, 2, -8, 1, 7, 4, -10};
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0,max=0;
        for(int i=0;i<nums.length;i++)
        
        {
            sum+=nums[i];
                if(sum==0)
                {
                    max=Math.max(max,i+1);
                }
                else {
                    if(map.containsKey(sum))
                    {
                        max=Math.max(max,(i)-map.get(sum));
                    }
                    else 
                        map.put(sum,i);
                }
        }
        System.out.println(max);
	}
}
