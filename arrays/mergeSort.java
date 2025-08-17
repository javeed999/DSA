#include <stdio.h>
int b[10];
void merge(int arr[], int low, int mid, int high)
{
    int i = low, j = mid + 1, k = low;
    while (i <= mid && j <= high)
    {
        if (arr[i] <= arr[j])
            b[k++] = arr[i++];
        else
            b[k++] = arr[j++];
    }
    while (i <= mid)
        b[k++] = arr[i++];
    while (j <= high)
        b[k++] = arr[j++];
    for (int i = low; i <= high; i++)
        arr[i] = b[i];
}

void mergeSort(int arr[], int low, int high)
{
    if (low < high)
    {
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
}
int arr[] = {10, 4, 5, 8, 2, 6,1,7,9,12};
int n = sizeof(arr) / sizeof(arr[0]);
void main()
{
     printf("List before sorting\n");

    for (int i = 0; i <n; i++)
        printf("%d\t", arr[i]);
        
    printf("\nList after sorting\n");
    mergeSort(arr, 0, n - 1);
    for (int i = 0; i < n; i++)
        printf("%d\t", arr[i]);
}
