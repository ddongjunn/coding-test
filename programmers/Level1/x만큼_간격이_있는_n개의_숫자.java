class Solution {
    public long[] solution(long x, int n) {
        long[] answer = new long[n];

        if(n >= 1000) return answer;

        long temp = x;
        for(int i=0; i<answer.length; i++){
            answer[i] = x;
            x = x + temp;
        }
        return answer;
    }
}