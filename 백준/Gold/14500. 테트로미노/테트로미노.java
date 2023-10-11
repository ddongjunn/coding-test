
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main{
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int[][] board;
    static boolean[][] isVisited;
    static int N, M, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                isVisited[i][j] = true;
                dfs(i, j, 0, 0);
                other(i, j);
                isVisited[i][j] = false;                
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int cnt, int sum) {
        if(cnt == 4){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                continue;
            }

            if(isVisited[nx][ny]){
                continue;
            }

            isVisited[nx][ny] = true;
            dfs(nx, ny, cnt + 1, sum + board[nx][ny]);
            isVisited[nx][ny] = false;
        }
    }

    private static void other(int i, int j) {
        if(i + 1 < N && j - 1 >= 0 && i - 1 >= 0){
            answer = Math.max(answer, board[i][j] + board[i-1][j-1] + board[i][j-1] + board[i+1][j-1]);
        }

        if(i - 1 >= 0 && i + 1 < N && j + 1 < M){
            answer = Math.max(answer, board[i][j] + board[i-1][j+1] + board[i][j+1] + board[i+1][j+1]);
        }

        if(i + 1 < N && j + 1 < M && j - 1 >= 0){
            answer = Math.max(answer, board[i][j] + board[i+1][j-1] + board[i+1][j] + board[i+1][j+1]);
        }

        if(i - 1 >= 0 && j - 1 >= 0 && j + 1 < M){
            answer = Math.max(answer, board[i][j] + board[i-1][j-1] + board[i-1][j] + board[i-1][j+1]);
        }
    }
}