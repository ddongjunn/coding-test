import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int priority : priorities){
            queue.offer(priority);
        }
        
        int answer = 0;
        while(true){
            for(int i = 0; i < priorities.length; i++){
                if(queue.peek() == priorities[i]){
                    queue.poll();
                    answer++;
                    
                    if(i == location){
                        return answer;
                    }   
                }        
            }
        }
    }
}