class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        for(int i = 3; i < total; i++) {
            int row = total / i;
            if(row < 3) {
                continue;
            }
            
            if(((row - 2) * (i - 2)) == yellow) {
                return new int[]{row, i};
            }
        }
        return new int[]{0, 0};
    }
}