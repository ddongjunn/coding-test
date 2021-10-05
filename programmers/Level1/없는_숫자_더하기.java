class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] chk = new boolean[10];
        
        for(int i = 0; i < numbers.length; i++){
            chk[numbers[i]] = true;
        }
        
        for(int j = 0; j < chk.length; j++){
            if(!chk[j]) answer += j;
        }
        
        
        return answer;
    }
}