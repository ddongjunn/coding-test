import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        
        long left = 0;
        long right = times[times.length - 1] * (long) n;
        while(left <= right) {
            long mid = (left + right) / 2;
            long people = 0;
            for(int time : times) {
                people += mid / time;
            }

            if(people < n) {
                left = mid + 1;
            } else if(people >= n) {
                answer = mid;
                right = mid - 1;
            }
       }
        return answer;
    }
}