class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char c;
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            if(48<= c && c <= 57){
                answer = true;
            }else{
                answer = false;
                break;
            }
        }
        if(s.length() != 4 && s.length() != 6){
            answer = false;
        }
        return answer;
    }
}

https://programmers.co.kr/learn/courses/30/lessons/12918