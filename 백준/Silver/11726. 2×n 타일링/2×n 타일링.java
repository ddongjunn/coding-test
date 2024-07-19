import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int mod = 10007;
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        System.out.println(dp[N]);
    }
}

/**
 * 2x1 => d[n - 1]
 * 1x2 => d[n - 2]
 * d[n] = d[n-1]+d[n-2];
 */