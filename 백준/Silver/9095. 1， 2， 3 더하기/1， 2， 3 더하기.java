import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[1] = 1; //1
        dp[2] = 2; //1 + 1, 2
        dp[3] = 4; //1 + 1 + 1, 1 + 2, 2 + 1, 3
        for(int j = 4; j < 11; j++) {
            dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
        }

        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = dp[Integer.parseInt(br.readLine())];
        }

        Arrays.stream(answer).forEach(a -> System.out.println(a));
    }
}