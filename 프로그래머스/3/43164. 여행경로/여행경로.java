import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static boolean[] visited;
    public static List<String> route;
    
    public String[] solution(String[][] tickets) {        
        visited = new boolean[tickets.length];
        route = new ArrayList();
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(route);
        return route.get(0).split(" ");
    }
    
    public void dfs(int depth, String start, String end, String[][] tickets) {
        if(depth == tickets.length) {
            route.add(end);
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], end + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}