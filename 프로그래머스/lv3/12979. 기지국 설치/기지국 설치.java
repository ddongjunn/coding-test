import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int idx = 0;
        int position = 1;
        while(position <= n){
            if(idx < stations.length && stations[idx] - w <= position){
                position = stations[idx] + w + 1;
                idx++;
            }else{
                position += (w * 2) + 1;
                answer++;
            }
        }

        return answer;
    }
}