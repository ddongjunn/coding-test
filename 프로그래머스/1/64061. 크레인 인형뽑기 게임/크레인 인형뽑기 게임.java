import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> bucket = new ArrayDeque<>();
        for (int move : moves) {
            int col = move - 1;

            for (int row = 0; row < board.length; row++) {
                int doll = board[row][col];
                if (doll == 0) continue;
                
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    answer += 2;
                    bucket.pop();
                } else {
                    bucket.push(doll);
                }
                
                board[row][col] = 0;
                break;
            }
        }
        return answer;
    }
}