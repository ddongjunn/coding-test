import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList();
        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int idx = 0;
        int totalWeightOnBridge = 0;
        while(idx < truck_weights.length) {
            answer++;
            totalWeightOnBridge -= bridge.poll();
            
            if(totalWeightOnBridge + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                totalWeightOnBridge += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }
        
        return answer + bridge_length;
    }
}