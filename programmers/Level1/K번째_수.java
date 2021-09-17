import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
    
        int[] answer = new int[commands.length];
        
        for(int x = 0 ; x < commands.length; x++){
            int[] temp = Arrays.copyOfRange(array, commands[x][0]-1, commands[x][1]);
            Arrays.sort(temp);
            answer[x] = temp[commands[x][2]-1];
        }
        
        return answer;
    }
}