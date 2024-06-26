import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        
        int min = 0;
        for(int max = people.length - 1; min <= max; max--) {
            if(people[min] + people[max] <= limit) {
                min++;
            }
            answer++;
        }
        
        return answer;
    }
}