import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] current = new int[N + 1];
        int[] clear = new int[N + 1];
        for(int i = 0; i < stages.length; i++) {
            for(int j = 0; j < stages[i]; j++) {
                clear[j]++;
            }
            current[stages[i] - 1]++;
        }

        Map<Integer, Double> map = new HashMap();
        for(int i = 0; i < N; i++) {
            if(current[i] == 0 || clear[i] == 0) {
                map.put(i + 1, 0.0);
            } else {
                map.put(i + 1, (double) current[i] / (double) clear[i]);
            }
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}