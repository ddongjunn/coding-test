import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        for(int rank = 0; rank < players.length; rank++){
            map.put(players[rank], rank);
        }
        
        for(String player : callings){
            int rank = map.get(player);
            
            String tmp = players[rank - 1];
            players[rank - 1] = players[rank];
            players[rank] = tmp;
            
            map.put(players[rank], rank);
            map.put(players[rank - 1], rank - 1);
        }
        
        return players;
    }
}