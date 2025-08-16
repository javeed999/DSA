 for (int j = 0; j < n; j++) {
            nums1[m + j] = nums2[j];
        }

        int len=m+n;
        int gap=(len/2)+ (len%2);
        while(gap>0)
        {
            int left=0;
            int right=gap+left;
            while(right<len)
            {
                // nums1 nums2
                if(nums1[left]>nums1[right])
                {
                    int temp=nums1[left];
                    nums1[left]=nums1[right];
                    nums1[right]=temp;
                }
                left++;
                right++;
            }
            if(gap==1) break;

            gap=(gap/2)+(gap%2);
        }

// 
// 
 
        int n1=arr1.length,n2=arr2.length;
        // int left=0,right=0,index=0;
        
        // while(left <n1 && right <n2)
        // {
        //     if(arr1[left]<arr2[right])
        //     {
        //         arr3[index++]=arr1[left++];
        //     }
        //     else 
        //     {
        //         arr3[index++]=arr2[right++];
        //     }
        // }
        
        // while(left<n1)
        // {
        //     arr3[index++]=arr1[left++];
        // }
        
        // while(right <n2)
        //     arr3[index++]=arr2[right++];
            
            
        // for(int num:arr3)
        //     System.out.print(num+" ");
        // 2nd approach
        int left=n1-1,right=0;
        while(left>=0 && right <n2)
        {
            
            if(arr1[left]>arr2[right])
            {
                int temp=arr1[left];
                arr1[left]=arr2[right];
                arr2[right]=temp;
                left--;
                right++;
            }
            else 
            {
                break;
            }     
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int num:arr1)
            System.out.print(num+" ");
	    System.out.println();
	    for(int num:arr2)
	        System.out.print(num+ " ");




















