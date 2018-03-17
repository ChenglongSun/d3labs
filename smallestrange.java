public int[] smallestRange(List<List<Integer>> nums) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(nums.size(), new Comparator<int[]>(){
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });

    int max = nums.get(0).get(0);
    for(int i=0; i<nums.size(); i++) {
        minHeap.add(new int[]{nums.get(i).get(0), i, 0}); //{val, row, idx}
        max = Math.max(max, nums.get(i).get(0));//max = max_val
    }
    
    int minRange = Integer.MAX_VALUE;
    int start = -1;

    while(minHeap.size() == nums.size()) {
        //update start and minRange
        int[] t = minHeap.poll();
        if(max - t[0] < minRange) {
            minRange = max - t[0];
            start = t[0];
        }
        //put next node in the same row into the heap
        if(t[2]+1 < nums.get(t[1]).size()) {
            t[0] = nums.get(t[1]).get(t[2]+1);
            t[2] ++;
            minHeap.add(t);
            max = Math.max(max, t[0]);//it maybe update the upper bound of the heap
        }
    }
    
    return new int[]{start, start+minRange};
}