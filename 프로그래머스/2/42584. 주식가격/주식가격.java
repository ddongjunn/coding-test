import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque();
        
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }    
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}