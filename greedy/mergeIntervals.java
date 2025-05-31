//test cases
//   N = 5
// [[1, 5], [2, 6], [8, 10], [7, 9], [12, 15]]
// output :[[1, 6], [7, 10], [12, 15]]
// example 2
// N = 5
// intervals = [[1, 3], [2, 4], [5, 7], [6, 8], [9, 10]]
//   [[1, 4], [5, 8], [9, 10]]

class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)-> (a[0]-b[0]));
        ArrayList<int [] > ans=new ArrayList<int []>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<n;i++)
        {
            if(end >= intervals[i][0])
                end= Math.max(end,intervals[i][1]);
            else
            {
                int arr[]={start,end};
                ans.add(arr);
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        int arr[]={start,end};
        ans.add(arr);
        int result[][]=new int[ans.size()][];
        for(int i=0;i<ans.size();i++)
        {
            result[i]=ans.get(i);

        }
        return result;
    }
}
