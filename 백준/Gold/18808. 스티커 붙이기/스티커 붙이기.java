import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, M, K, R, C;
    static int[][] note = new int[40][40];
    static int[][] sticker = new int[11][11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (; K > 0; K--) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            for(int i = 0; i < R; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < C; j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            post : for(int rot = 0; rot < 4; rot++){
                for(int i = 0; i <= N - R; i++){
                    for(int j = 0; j <= M - C; j++){
                        if(postable(i, j)){
                            break post;
                        }
                    }
                }
                rotate();
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(note[i][j] == 1){
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }

    private static boolean postable(int x, int y) {
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(note[i + x][j + y] == 1 && sticker[i][j] == 1){
                    return false;
                }
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(sticker[i][j] == 1){
                    note[i + x][j + y] = 1;
                }
            }
        }
        return true;
    }

    private static void rotate() {
        int[][] tmp = new int[11][11];
        for(int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                tmp[i][j] = sticker[i][j];
            }
        }

        for(int i = 0; i < C; i++){
            for(int j = 0; j < R; j++){
                sticker[i][j] = tmp[R - 1 - j][i];
            }
        }
        
        swap();
    }

    private static void swap() {
        int tmp = R;
        R = C;
        C = tmp;
    }
}