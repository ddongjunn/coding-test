import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, answer;
    static int[][] board;
    static int[][] board2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        board2 = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int tmp = 0; tmp < 1024; tmp++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    board2[i][j] = board[i][j];
                }
            }

            int brute = tmp;
            for(int i = 0; i < 5; i++){
                int dir = brute % 4;
                brute /= 4;
                tilt(dir);
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    answer = Math.max(answer, board2[i][j]);
                }
            }
        }
        System.out.println(answer);
    }

    private static void tilt(int dir) {
        while(dir-- > 0){
            rotate();
        }

        for(int i = 0; i < N; i++){
            int tilt[] = new int[N];
            int idx = 0;
            for(int j = 0; j < N; j++){
                if(board2[i][j] == 0){
                    continue;
                }

                if(tilt[idx] == 0){
                    tilt[idx] = board2[i][j];
                }else if(tilt[idx] == board2[i][j]){
                    tilt[idx++] *= 2;
                }else{
                    tilt[++idx] = board2[i][j];
                }
            }

            for(int j = 0; j < N; j++){
                board2[i][j] = tilt[j];
            }
        }
    }

    private static void rotate() {
        int[][] tmp = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                tmp[i][j] = board2[i][j];
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board2[i][j] = tmp[N - 1 - j][i];
            }
        }
    }
}