import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        
        int ans = 0;
        int n = score.length;
        
        int boxCount = n / m;
        for(int i = 0; i < boxCount; i++) {
            int minScore = score[n - (i + 1) * m];
            ans += minScore * m;
        }
        
        return ans;
    }
}