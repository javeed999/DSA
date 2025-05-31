// Approach
// Sort intervals by their end times to prioritize those that finish earliest.

// Start with the first interval and count it as non-overlapping.

// For each subsequent interval, if it starts after the previous interval's end, include it in the non-overlapping count and update the end time.

// The result is the total number of intervals minus the count of non-overlapping intervals.
// Example1 
// intervals = [[2, 3], [3, 4], [4, 5], [2, 4]]
// Output:1
// intervals = [[2, 3], [4, 5], [1, 7], [6, 8], [9, 10], [6, 10]]
// Output:2



class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        if(n==0) return 0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int count=1;
        int end=intervals[0][1];
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0]>=end)
            {
                count++;
                end=intervals[i][1];
            }
        }
        return n-count;
    }
}
