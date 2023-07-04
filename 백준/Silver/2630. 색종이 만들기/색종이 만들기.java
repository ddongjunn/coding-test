import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] board;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void solution (int x, int y, int size){
        if(colorCheck(x, y, size)){
            if(board[x][y] == 1){
                blue++;
            }else if(board[x][y] == 0){
                white++;
            }
            return;
        }

        int newSize = size / 2;

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                solution(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }

    private static boolean colorCheck(int x, int y, int size) {
        int color = board[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(color != board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}