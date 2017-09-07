class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        List<Interval> res = new ArrayList<Interval>();
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
//         int i = 0, j = 0;
//         for(; i < n; i++) {
//             if (i == n - 1 || starts[i + 1] > ends[i]) res.add(new Interval(starts[j], ends[i]));
//             j = i + 1;
            
//         }
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}