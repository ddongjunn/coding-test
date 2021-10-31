import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] player1 = {1, 2, 3, 4, 5};
        int[] player2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] player3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = {0, 0, 0};
        
        //채점
        for(int i = 0; i < answers.length; i++){
            if(player1[i % player1.length] == answers[i]) score[0]++;
            if(player2[i % player2.length] == answers[i]) score[1]++;
            if(player3[i % player3.length] == answers[i]) score[2]++;
        }
        
        //가장 큰 점수
        int maxScore = Math.max(score[0], Math.max(score[1],score[2]));
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(maxScore == score[0]) list.add(1);
        if(maxScore == score[1]) list.add(2);
        if(maxScore == score[2]) list.add(3);
        
        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
