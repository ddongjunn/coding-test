import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < survey.length; i++) {
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);

            if(choices[i] > 4) {
                map.put(right, map.getOrDefault(right, 0) + choices[i] - 4);
            } else if(choices[i] < 4) {
                map.put(left, map.getOrDefault(left, 0) + Math.abs(choices[i] - 4));
            }
        }

        StringBuilder sb = new StringBuilder();
        String[] pairs = {"RT", "CF", "JM", "AN"};
        for(String pair : pairs) {
            char left = pair.charAt(0);
            char right = pair.charAt(1);
            int leftVal = map.getOrDefault(left, 0);
            int rightVal = map.getOrDefault(right, 0);
            
            sb.append(leftVal >= rightVal ? left : right);
        }
        
        return sb.toString();
    }
}