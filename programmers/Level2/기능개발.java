import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       
        int[] work = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int count = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                count++;
            }
            work[i] = count;
        }

        ArrayList<Integer> list = new ArrayList<>();
        int temp = work[0];
        int count = 1;

        for (int i = 1; i < work.length; i++) {
            if(temp >= work[i]){
                count++;
            }else{
                list.add(count);
                temp = work[i];
                count = 1;
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
