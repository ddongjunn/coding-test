import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder(); 
        for(char letter : s.toCharArray()) {
            char temp = letter;
            int shift = 0;
            while(shift < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if(!skip.contains(String.valueOf(temp))) {
                    shift++;
                }
            }
            answer.append(temp);
        }
        
        return answer.toString();
    }
}