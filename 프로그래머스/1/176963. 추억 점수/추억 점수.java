import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> score = new HashMap();
        for(int i = 0 ; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (String s : photo[i]) {
                answer[i] += score.getOrDefault(s, 0);
            }
        }
        return answer;
    }
}