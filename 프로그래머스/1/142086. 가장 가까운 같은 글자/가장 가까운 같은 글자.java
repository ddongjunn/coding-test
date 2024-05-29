import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            answer[i] = i - map.getOrDefault(word, i + 1);
            map.put(word, i);
        }   
        
        return answer;
    }
}