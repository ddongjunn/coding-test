import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n){
            answer += n %10;
            n = n/10;
            answer +=n;
        }

        return answer;
    }
}

https://programmers.co.kr/learn/courses/30/lessons/12931