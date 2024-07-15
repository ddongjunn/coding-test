class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int x = wallpaper.length;
        int y = wallpaper[0].length();

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        char[][] board = new char[x][y];
        for(int i = 0; i < x; i++) {
            String str = wallpaper[i];
            for(int j = 0; j < y; j++) {
                board[i][j] = str.charAt(j);

                if(board[i][j] == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX + 1;
        answer[3] = maxY + 1;
        return answer;
    }
}