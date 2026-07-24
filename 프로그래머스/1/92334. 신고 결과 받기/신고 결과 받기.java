import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            count.put(id_list[i], 0);
        }
        
        for (int i = 0; i < report.length; i++) {
            String source = report[i].split(" ")[0];
            String dest = report[i].split(" ")[1];
            
            Set destSet = map.get(source);
            destSet.add(dest);
        }
        
        for (int i = 0; i < id_list.length; i++) {            
            for (String id : map.get(id_list[i])) {
                count.put(id, count.get(id) + 1);
            }
        }
    
        int[] ans = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String source = id_list[i];
            
            for (String sources : map.get(source)) {
                if (count.get(sources) >= k) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}