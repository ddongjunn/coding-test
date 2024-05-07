import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        int rank = 0;
        for(String player : players){
           map.put(player, rank++); 
        }
        
        for(String player : callings){
            int order = map.get(player);
            map.put(player, map.get(player) - 1);
            map.put(players[order - 1], map.get(players[order - 1]) + 1);
            
            String tmp = players[order - 1];
            players[order - 1] = players[order];
            players[order] = tmp;
        }
        
        return players;
    }
}