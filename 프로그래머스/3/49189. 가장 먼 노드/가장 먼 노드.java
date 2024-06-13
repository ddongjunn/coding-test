import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList(n + 1);    
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] distance = bfs(n, graph);
        int max = Arrays.stream(distance).max().getAsInt();
        return (int) Arrays.stream(distance).filter(i -> i == max).count();
    }
    
    public int[] bfs(int n, List<List<Integer>> graph) {
        int[] distance = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList();
        
        isVisited[1] = true;
        queue.add(1);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int neighbor : graph.get(current)) {
                if(!isVisited[neighbor]) {
                    queue.add(neighbor);
                    isVisited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;                    
                }
            }
        }
        
        return distance;
    }
}