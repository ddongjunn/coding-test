class Solution {
    public int solution(int[][] land) {
        final int ROW = land.length;
        final int COL = 4;

        for (int i = 1; i < ROW; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        return Math.max(land[ROW - 1][0], Math.max(land[ROW - 1][1], Math.max(land[ROW - 1][2], land[ROW - 1][3])));
    }
}