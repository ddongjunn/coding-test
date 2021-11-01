class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int zero = 0;
        int matched = 0;
        
        for(int i : lottos){
            if(i == 0){
                zero++;
            }
            else{
                for(int j : win_nums){
                    if(i == j) {
                        matched++; 
                        break;
                    }
                }
            }
        }
        
        int min = matched;
        int max = matched + zero;
        
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        
        int[] answer = {Math.min(7 - max, 6), Math.min(7 - min, 6)};
        
        return answer;
    }
}
