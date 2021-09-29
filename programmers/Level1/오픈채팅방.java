import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> userInfo = new HashMap<String,String>();
        
        int idx = 0; //answer의 길이
        for(String str : record){
            String[] parsing = str.split(" ");
            if(parsing[0].equals("Enter")){
                userInfo.put(parsing[1],parsing[2]);
                idx++;
            }else if(parsing[0].equals("Change")){
                userInfo.put(parsing[1],parsing[2]);
            }else{
                idx++;
            }
        }
        
        String[] answer = new String[idx];
        idx = 0;
        for(String str : record){
            String[] parsing = str.split(" ");
            if(parsing[0].equals("Enter")){
                answer[idx] = userInfo.get(parsing[1]) + "님이 들어왔습니다.";
                idx++;
            }else if(parsing[0].equals("Leave")){
                answer[idx] = userInfo.get(parsing[1]) + "님이 나갔습니다.";
                idx++;
            }
        }
        
        return answer;
    }
}