class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase(); //1단계
        
        for(int i = 0; i < new_id.length(); i++){
            if( ('0' <= new_id.charAt(i) && new_id.charAt(i) <= '9') //2단계
               || ('a' <= new_id.charAt(i) && new_id.charAt(i) <= 'z')
               || new_id.charAt(i) == '-'
               || new_id.charAt(i) == '_' 
               || new_id.charAt(i) == '.'){
                answer += new_id.charAt(i);
            }
        }
        answer = answer.replaceAll("[.]{2,}","."); //3단계
        
        if(answer.charAt(0) == '.'){ //4단계
             answer = answer.substring(1, answer.length()); 
        }else if(answer.charAt(answer.length() - 1) == '.'){
            answer = answer.substring(0, answer.length() - 1);
        }

        if(answer.length() == 0) answer += "a"; //5단계
        
        if(answer.length() >= 16) answer = answer.substring(0,15); //6단계
        if(answer.charAt(answer.length() -1 ) == '.') answer = answer.substring(0, answer.length() - 1);
        
        if(answer.length() == 1){ //7단계
            answer += answer + answer;
        }else if(answer.length() == 2){
            answer += answer.charAt(1) + "";
        }
        
        return answer;
    }
}