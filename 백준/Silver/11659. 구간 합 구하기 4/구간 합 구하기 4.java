import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] n = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = n[1];
        for(int i = 1; i <= N; i++) {
            n[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + n[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(dp[y] - dp[x - 1]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
