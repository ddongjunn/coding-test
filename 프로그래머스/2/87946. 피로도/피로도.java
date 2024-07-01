class Solution {
    public static int ans = 0;
    public static boolean[] isVisited;
    
    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return ans;
    }
    
    public static void dfs(int tired, int[][] dungeons, int cnt) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!isVisited[i] && tired >= dungeons[i][0]) {
                isVisited[i] = true;
                dfs(tired - dungeons[i][1], dungeons, cnt + 1);
                isVisited[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }
}