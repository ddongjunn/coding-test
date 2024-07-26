import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(findMaxValue(0, 0));
    }

    public static int findMaxValue(int row, int col) {
        if(row == N - 1) {
            return dp[row][col];
        }

        if(dp[row][col] == null) {
            dp[row][col] = Math.max(findMaxValue(row + 1, col), findMaxValue(row + 1, col + 1)) + arr[row][col];
        }

        return dp[row][col];
    }
/*
    public static int max(int[][] arr, int[][] dp, int row, int col) {
        if(dp[row][col] == -1) {
            if(col == 0) {
                dp[row][col] = max(arr, dp, row - 1, col) + arr[row][col];
            } else if(row == col) {
                dp[row][col] = max(arr, dp, row -1, col -1) + arr[row][col];
            } else {
                dp[row][col] = Math.max(max(arr, dp, row - 1, col), max(arr, dp, row - 1, col - 1)) + arr[row][col];
            }
        }
        return dp[row][col];
    }
 */
}