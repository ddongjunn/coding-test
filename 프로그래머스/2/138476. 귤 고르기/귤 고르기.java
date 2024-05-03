import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : tangerine){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        int answer = 0;
        for(Integer n : list){
            answer++;
            k -= map.get(n);
            if(k <= 0){
                return answer;
            }
        }
        
        return answer;
    }
}