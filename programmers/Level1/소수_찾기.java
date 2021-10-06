import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] chk = new boolean[n + 1];
    
        //2~n번째 수를 true로  초기화
        for(int i = 2; i <= n; i++) chk[i] = true;
        
        //제곱근구하기
        int root = (int) Math.sqrt(n);
        
        for(int i = 2; i <= root; i++){
            if(chk[i]){
                for(int j = i; i * j <= n; j++){
                    chk[i*j]=false;
                }
            }
        }
        
        for(int i = 2; i <= n; i++){
           if(chk[i]) answer++; 
        }

        return answer;
    }
}