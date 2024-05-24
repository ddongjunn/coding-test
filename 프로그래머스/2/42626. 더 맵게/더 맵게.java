import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int sacle : scoville){
            heap.add(sacle);
        }

        int mixCount = 0;
        while(heap.size() > 1 && heap.peek() < K) {
            int first = heap.poll();
            int second = heap.poll();
            heap.add(first + (second * 2));
            mixCount++;
        }
        
        if(heap.peek() < K){
            return -1;    
        }
        return mixCount;
    }
}