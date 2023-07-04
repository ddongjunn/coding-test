import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    static String[][] board;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new String[N][N];

        solution(0, 0, N);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(board[i][j] == null ? " " : board[i][j]);
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void solution(int x, int y, int size){
        if(size == 1){
            board[x][y] = "*";
            return;
        }

        int newSize = size / 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!(i == 1 && j == 1)){
                    solution(x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }
}