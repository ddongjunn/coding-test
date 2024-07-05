import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<String> queue = new LinkedList();
        queue.offer(begin);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String current = queue.poll();
                if(current.equals(target)) {
                    return answer;
                }
                
                for(int j = 0; j < words.length; j++) {
                    if(!visited[j] && isTransfer(current, words[j])) {
                        visited[j] = true;
                        queue.offer(words[j]);
                    }
                }
            }
            answer++;
        }
        return 0;
    }
    
    public boolean isTransfer (String from, String to) {
        int diff = 0;
        for(int i = 0; i < from.length(); i++) {
            if(from.charAt(i) != to.charAt(i)) {
                diff++;
            }
            
            if(diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}