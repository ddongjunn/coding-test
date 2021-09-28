import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = "";
        String temp = "";

        HashMap<String, Integer> strToNum = new HashMap<String, Integer>() {{
            put("zero", 0); put("one", 1); put("two", 2); put("three", 3); put("four", 4); 
            put("five", 5); put("six", 6); put("seven", 7); put("eight", 8); put("nine", 9); 
        }}
        
        for (char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') answer += c;
            else temp += c;

            if(strToNum.containsKey(temp)) {
                answer += strToNum.get(temp);
                temp = "";
            }
        }
        
        return Integer.parseInt(answer);
    }
}