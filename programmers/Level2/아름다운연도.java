public class Solution {
    public int solution(int p) {
        String answer = "";
        String strP = "";
        
        boolean chk[];
        
        for(int x = (p + 1); x <= 10000; x++){
            strP = x + "";
            chk = new boolean[10];
            
            int count = 0;
            for(int y = 0; y < strP.length(); y++){
                
                if(chk[strP.charAt(y) - '0']) break;
    
                if(!chk[strP.charAt(y) - '0']){
                    chk[strP.charAt(y) - '0'] = true;
                    count++;
                    answer += Character.toString(strP.charAt(y));
                   
                }
            }
            
            if(count == 4){
                break;
            }else{
                answer = "";
            }
        }
        return Integer.parseInt(answer);
    }
}
