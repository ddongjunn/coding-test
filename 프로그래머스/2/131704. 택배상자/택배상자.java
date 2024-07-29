import java.util.*;

class Solution {
    public int solution(int[] order) {
        int truck = 0;
        int idx = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 1; i <= order.length; i++) {
            stack.push(i);
            while(!stack.isEmpty()) {
                if(stack.peek() == order[idx]) {
                    stack.poll();
                    idx++;
                    truck++;
                } else {
                    break;
                }
            }
        }
        
        return truck;
    }
}