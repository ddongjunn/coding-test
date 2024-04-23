import java.util.Arrays;
import java.util.stream.IntStream;

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < B.length / 2; i++){
            int temp = B[i];
            B[i] = B[B.length - 1 - i];
            B[B.length - 1 - i] = temp;
        }
        
        return IntStream.range(0, A.length)
            .map(i -> A[i] * B[i])
            .sum();
    }
}