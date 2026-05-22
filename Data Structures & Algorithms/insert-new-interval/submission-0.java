class Solution {
    public int[][] insert(int[][] interval, int[] newInterval) {

        int ni = interval.length;
        int intervals[][] = new int[ni+1][2];

        for(int i=0; i<ni; i++){
            intervals[i][0] = interval[i][0];
            intervals[i][1] = interval[i][1];
        }

        intervals[ni][0] = newInterval[0];
        intervals[ni][1] = newInterval[1];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=1; i<intervals.length; i++){
            if(end >= intervals[i][0]){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                ans.add(new ArrayList(List.of(start, end)));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        ans.add(new ArrayList(List.of(start, end)));

        int n = ans.size();
        int result[][] = new int[n][2];

        for(int i=0; i<n; i++){
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        return result;

    }
}
