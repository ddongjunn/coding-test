class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int row = 0;
        int col = 0;
        
        //가로를 max 기준으로
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = tmp;
            }
            
            row = Math.max(row, sizes[i][0]);
            col = Math.max(col, sizes[i][1]);
        }
        
    
        return row * col;
    }
}