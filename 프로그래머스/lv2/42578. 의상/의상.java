import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> counts = new HashMap<String,Integer>();

        for(String[] c : clothes){
            String type = c[1];
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }
       
        int answer = 1;
        for(Integer c : counts.values()){
            answer *= c + 1; //종류의 갯수들을 곱하고, 사용하지 않는 경우도 있으니 + 1을 추가
        }

        answer -= 1; //모든 용품을 다 사용하지 않는 경우

        return answer;
    }
}