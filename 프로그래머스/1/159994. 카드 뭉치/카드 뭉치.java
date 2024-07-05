import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> card1 = new LinkedList();
        Queue<String> card2 = new LinkedList();
        
        for(String s : cards1) {
            card1.offer(s);
        }
        
        for(String s : cards2) {
            card2.offer(s);
        }
        
        for(String s : goal) {
            if(!card1.isEmpty() && s.equals(card1.peek())) {
                card1.poll();
            } else if(!card2.isEmpty() && s.equals(card2.peek())) {
                card2.poll();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}