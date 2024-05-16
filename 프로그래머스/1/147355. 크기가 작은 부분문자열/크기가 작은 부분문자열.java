class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pToLong = Long.parseLong(p);
        int pLength = p.length();
        
        for(int i = 0; i <= t.length() - pLength; i++) {
            long currentNumber = Long.parseLong(t.substring(i, i + pLength));
            if(currentNumber <= pToLong) {
                answer++;
            }
        }
        
        return answer;
    }
}