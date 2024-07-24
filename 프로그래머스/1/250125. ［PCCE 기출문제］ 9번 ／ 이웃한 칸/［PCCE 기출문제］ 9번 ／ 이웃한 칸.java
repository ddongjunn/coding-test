class Solution {
    final int[] dx = {1, -1, 0, 0};
    final int[] dy = {0, 0, 1, -1};
    
    public int solution(String[][] board, int h, int w) {
        int row = board.length;
        int col = board[0].length;
        int answer = 0;
        for(int dir = 0; dir < 4; dir++) {
            int nx = h + dx[dir];
            int ny = w + dy[dir];

            if(nx < 0 || ny < 0 || nx >= row || ny >= col) {
                continue;
            }
            
            if(board[h][w].equals(board[nx][ny])) {
                answer++;
            }
        }
        
        return answer;
    }
}