class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int sum = 0;
        int start = 1;
        int end = 1;
        while(start <= n){
            if (sum == n) {
                answer++;
                sum -= start++;
                continue;
            }

            if (sum < n) {
                sum += end++;
            } else {
                sum -= start++;
            }
        }
        
        return answer;
    }
}