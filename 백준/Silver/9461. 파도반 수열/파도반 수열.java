import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new long[102];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(findWaveSequence(N)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static long findWaveSequence(int N) {
        if(dp[N] == -1) {
            dp[N] = findWaveSequence(N - 2) + findWaveSequence(N - 3);
        }
        return dp[N];
    }
}