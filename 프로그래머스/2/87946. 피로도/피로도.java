class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] isVisited = new boolean[dungeons.length];
        return dfs(k, dungeons, 0, isVisited);
    }
    
    public int dfs(int k, int[][] dungeons, int cnt, boolean[] isVisited) {
        int n = 0;
        for (int i = 0; i < dungeons.length; i++) {
            if (isVisited[i]) continue;
            
            if (k >= dungeons[i][0]) {
                isVisited[i] = true;
                n = Math.max(n, dfs(k - dungeons[i][1], dungeons, cnt + 1, isVisited));
                isVisited[i] = false;
            }
        }
        return Math.max(n, cnt);
    }
}