class Solution {
    public String nextClosestTime(String time) {
        int[] raw = new int[4];
        
        raw[0] = time.charAt(0) - '0';
        raw[1] = time.charAt(1) - '0';
        raw[2] = time.charAt(3) - '0';
        raw[3] = time.charAt(4) - '0';
        
        int[] num = Arrays.copyOf(raw, 4);
        int[] draft = Arrays.copyOf(raw, 4);
        
        Arrays.sort(num);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) map.put(num[i], i);
        
        for (int i = 3; i >= 0; i--) {
            int idx = map.get(draft[i]);
            if (idx < 3) {
                draft[i] = num[idx + 1];
                for (int j = i + 1; j < 4; j++) {
                    draft[j] = num[0];
                }
                if (draft[0] * 10 + draft[1] < 24 && draft[2] * 10 + draft[3] < 59) {
                    return "" + draft[0] + draft[1] + ':' + draft[2] + draft[3];
                }
            }
        }
        return "" + num[0] + num[0] + ':' + num[0] + num[0];
    }
}