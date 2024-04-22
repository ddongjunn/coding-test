import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int max = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .max()
            .orElse(Integer.MIN_VALUE);

        int min = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .min()
            .orElse(Integer.MAX_VALUE);
        
        answer += min + " " + max;
        
        return answer;
    }
}