class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[computers.length];
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                answer++;
                dfs(i, computers, visited);    
            }
        }
        return answer;
    }
    
    public void dfs (int node, int[][]computers, boolean[] visited) {
        visited[node] = true;
        
        for(int i = 0; i < computers.length ; i++) {
            if(!visited[i] && computers[node][i] == 1) {
                dfs(i, computers, visited);
            }
        }
    }
}