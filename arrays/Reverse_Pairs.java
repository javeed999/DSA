class Solution {

      public static void merge(int arr[],int low,int mid,int high,int b[])
    {
        int i=low,j=mid+1,k=low;

        while(i<=mid && j<=high)
        {
            if(arr[i]<=arr[j])
            {
                b[k++]=arr[i++];
            }
            else 
            {
                b[k++]=arr[j++];
            }
        }
        
        
        while(i<=mid)
            b[k++]=arr[i++];
        while(j<=high)
            b[k++]=arr[j++];

    for(int l=low;l<=high;l++)
    {
        arr[l]=b[l];
    }


    }

    
    public static int countPairs(int arr[],int low,int  mid,int high)
    {
        int right=mid+1;
        int ans=0;
        for(int i=low;i<=mid;i++)
        {
            while (right <= high && (long)arr[i] > 2L * (long)arr[right])
            right++;

            ans+=right-(mid+1);
        }
        return ans;
    }
    
    public static int mergeSort(int arr[],int low,int high,int b[])
    {
        int count=0;
        if(low<high)
        {
            int mid=(low+high)/2;
            count+=mergeSort(arr,low,mid,b);
            count+=mergeSort(arr,mid+1,high,b);
            count+=countPairs(arr,low,mid,high);
           merge(arr,low,mid,high,b);

        }
        return count;
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        int b[]=new int[n];
        int ans=mergeSort(nums,0,n-1,b);
        return ans;
    }
}
