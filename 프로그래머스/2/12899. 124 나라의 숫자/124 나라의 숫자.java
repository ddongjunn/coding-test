class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        String[] arr = {"1", "2", "4"};
        while(n > 0) {
            n--;
            answer.append(arr[n % 3]);
            n /= 3;
        }
        return answer.reverse().toString();
    }
}