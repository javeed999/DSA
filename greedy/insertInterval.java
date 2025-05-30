class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List< int [] > ans=new ArrayList<int [] >();
        int i=0;
        int n=intervals.length;
        while(i<n && intervals[i][1]<newInterval[0])
        {
            ans.add(intervals[i]);
            i++;
        }
        int start = newInterval[0];
        int end = newInterval[1];

        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        ans.add(new int[] {start, end});

        while(i<n)
        {
            ans.add(intervals[i]);
            i++;
        }
        int len=ans.size();
        int result[][]=new int[len][2];
        int j=0;
        for(int[] num:ans)
        {
            result[j++]=num;
        }
        return result;
    }
}
