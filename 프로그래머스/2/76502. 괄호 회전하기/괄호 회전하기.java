import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(isBracket(s)) {
                answer++;
            }
            s = shift(s);
        }
        return answer;
    }

    public boolean isBracket(String word) {
        Stack<Character> stack = new Stack<>();
        for(char c : word.toCharArray()) {
            if(c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.peek();
                if((open == '[' && c == ']') || (open == '{' && c == '}') || (open == '(' && c == ')')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public String shift(String s) {
        return s.substring(1) + s.charAt(0);
    }
}