class Solution {
    public int[] solution(long n) {    
        String strNum = n + "";

        int[] answer = new int[strNum.length()];
        
        int idx = 0;
        for(int j = strNum.length(); j > 0; j--){
             answer[idx] = strNum.charAt(j - 1) - '0';
             idx++;
        }
        
        return answer;
    }
}