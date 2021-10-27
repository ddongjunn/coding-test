import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                map.put(numbers[i] + numbers[j], numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[map.size()];
        
        int idx = 0;
        for(int key : map.keySet()){
            answer[idx] = map.get(key);
            idx++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
