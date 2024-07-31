import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 2];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(tile(N));
    }

    public static int tile(int N) {
        if(dp[N] == -1) {
            dp[N] = (tile(N - 1) + tile(N - 2)) % 15746;
        }
        return dp[N];
    }
}
