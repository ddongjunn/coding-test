class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length()%2 == 0){
            int i = s.length() / 2;
            answer = String.valueOf(s.charAt(i-1));
            answer += String.valueOf(s.charAt(i));
        }else{
            int i = s.length() / 2;
            answer = String.valueOf(s.charAt(i));
        }
        return answer;
    }
}