class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 0; i < number; i++) {
            int factorCount = getFactorCount(i + 1);
            answer += factorCount > limit ? power : factorCount;
        }
        return answer;
    }
    
    public int getFactorCount(int num) {
        int count = 0;
        for(int i = 1; i <= (int) Math.sqrt(num); i++) {
            if(num % i == 0) {
                count += (i * i == num) ? 1 : 2;
            }
        }
        return count;
    }
}