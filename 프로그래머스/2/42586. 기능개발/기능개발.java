import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int workDay = (remainingWork + speeds[i] - 1) / speeds[i];
            q.add(workDay);
        }

        int currentDay = q.poll();
        int count = 1;
        while(!q.isEmpty()) {

            if(currentDay >= q.peek()) { 
                count++;
                q.poll();
            } else {
                answer.add(count);
                count = 1;
                currentDay = q.poll();
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}