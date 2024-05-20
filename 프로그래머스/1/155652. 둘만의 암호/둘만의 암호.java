import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        Set<Character> skipSet = new HashSet<>();
        for(char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        int shift = 0;
        for(int i = 0; i < s.length(); i++) {
            int asciiValue = s.charAt(i);
            while(shift < index){
                asciiValue++;
                if(asciiValue > 'z') {
                    asciiValue = 'a';
                }

                if(skipSet.contains((char) asciiValue)) {
                    continue;
                }
                shift++;
            }
            answer.append((char) asciiValue);
            shift = 0;
        }
        
        return answer.toString();
    }
}