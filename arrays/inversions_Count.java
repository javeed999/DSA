/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
    public static int merge(int arr[],int low,int mid,int high,int b[])
    {
        int i=low,j=mid+1,k=low;
        int count=0;
        while(i<=mid && j<=high)
        {
            if(arr[i]<=arr[j])
                b[k++]=arr[i++];
            else 
            {
                b[k++]=arr[j++];
                count+=(mid-i+1);
            }
        }
        
        
         while (i <= mid)
        b[k++] = arr[i++];
         while (j <= high)
        b[k++] = arr[j++];
        
        for(int l=low;l<=high;l++)
            arr[l]=b[l];
        return count;
    }
    
    
    
    public static int mergeSort(int arr[],int low,int high,int b[])
    {
                    int count=0;

        if(low<high)
        
        {
            int mid=(low+high)/2;
            count+=mergeSort(arr,low,mid,b);
            count+=mergeSort(arr,mid+1,high,b);
            count+=merge(arr,low,mid,high,b);
        }
        return count;
    }
	public static void main(String[] args) {


    int arr[]={5,4,2,1,3};
    int n=arr.length;
        int b[]=new int[n];

    int ans=mergeSort(arr,0,n-1,b);
    for(int num:b)
        System.out.print(num+" ");

    	System.out.println();
	System.out.println(ans);



	}
}
