import java.util.List;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> min = new PriorityQueue();
        for(int i = 0; i < score.length; i++) {
            int cur = score[i];
        
            if(min.size() < k) {
                min.offer(cur);
            } else if (cur > min.peek()){
                min.poll();
                min.offer(cur);
            }
            
            answer[i] = min.peek();
        }
        return answer;
    }
}