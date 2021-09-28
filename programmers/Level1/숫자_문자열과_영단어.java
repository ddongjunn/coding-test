class Solution {
    public int solution(String s) {
        String answer = "";
        
        String temp = "";
        String[] strList = {"zero", "one", "two", "three", "four", 
                        "five", "six", "seven", "eight", "nine"};
        
        for (char c : s.toCharArray()){
            if(c >= '0' && c <= '9') {
                answer += c;
            }else{
                temp += c;
            }
            
            for(int i = 0; i < strList.length; i++){
                if(temp.equals(strList[i])){
                    answer += (i + "");
                    temp = "";
                    break;
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
}