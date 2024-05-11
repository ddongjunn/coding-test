import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] board, int[] moves) {    
        Deque<Integer> stack = new ArrayDeque<>();
        
        int answer = 0;
        for(int move : moves) {
            move = move - 1;
            
            for(int i = 0; i < board.length; i++) {
                int doll = board[i][move];
                
                if(doll != 0) {
                    board[i][move] = 0;
                    
                    if(!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}