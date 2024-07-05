import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n; i++) {
            if(!visited[i]) {
                bfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(int node, int[][] computers, boolean[] visited) {    
        Queue<Integer> q = new LinkedList();
        q.add(node);
        
        visited[node] = true;
        
        while(!q.isEmpty()) {
            int current = q.poll();
            
            for(int i = 0; i < computers[current].length; i++) {
                if(computers[current][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}