import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] board;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }

        solution(0, 0, N);

        System.out.println(sb.toString());
    }

    public static void solution(int x, int y, int size){
        
        if(numCheck(x, y, size)){
            sb.append(board[x][y]);
            return;
        }

        int newSize = size / 2;
        
        sb.append("(");
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                solution(x + i * newSize, y + j * newSize, newSize);
            }
        }
        sb.append(")");
    }

    private static boolean numCheck(int x, int y, int size){
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