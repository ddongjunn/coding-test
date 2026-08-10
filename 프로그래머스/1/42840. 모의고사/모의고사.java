import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] person = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int p = 0; p < person.length; p++) {
                if (answers[i] == person[p][i % person[p].length]) {
                    score[p]++;
                }
            }
        }        
       
        int max = Arrays.stream(score).max().getAsInt();
        
        return IntStream.range(0, 3)
            .filter(p -> score[p] == max)
            .map(p -> p + 1)
            .toArray();
    }
}