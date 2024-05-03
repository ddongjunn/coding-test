import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : tangerine){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue()- o1.getValue());

        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : entryList){
            idx++;
            k -= entry.getValue();
            if(k <= 0){
                return idx;
            }
        }
        
        return 0;
    }
}