import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] map = new int[n];
        
        for(int i = 0 ; i < map.length; i++){ //or연산
            map[i] = arr1[i] | arr2[i];
        }
        
        for(int i = 0 ; i < map.length; i++){
            String temp = Integer.toBinaryString(map[i]);
            
            if(temp.length() < n){ //자릿수가 n보다 부족한경우
                int diff = n - temp.length();//차이값 계산
                
                for(int j = 0; j < diff; j++){//차이만큼 앞자리 0으로 채우기
                    temp = "0" + temp;
                }
            }
            
            temp = temp.replaceAll("1","#");
            temp = temp.replaceAll("0"," ");
            answer[i] = temp;
        }
        
        return answer;
    }
}
