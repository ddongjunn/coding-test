import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> keys = new HashMap();
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                char ch = keymap[i].charAt(j);             
                keys.put(ch, Math.min(keys.getOrDefault(ch, Integer.MAX_VALUE), j + 1));
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            for(int j = 0; j < targets[i].length(); j++) {
                char key = targets[i].charAt(j);
                if(!keys.containsKey(key)) {
                    answer[i] = -1;
                    break;
                }   
                answer[i] += keys.get(key);
            }
        }
        
        return answer;
    }
}

/**
*
String s = "ABCDE";
int i = s.indexOf("D");
System.out.println(i); //0부터 시작
+1을 해줘야하고 없는 경우에는 -1 임 


targets 만큼 반복이 필요하고

targets는 keymap만큼 반복이 필요
*/

