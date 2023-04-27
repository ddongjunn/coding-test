import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {1, 0, -1, 0};
    static int[][] board;
    static int[][][] dist;
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dist = new int[2][N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    static public int bfs(){
        initializeDistArray();
        
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(0, 0, 0));

        while(!q.isEmpty()){
            Pos pos = q.poll();

            if(pos.x == N - 1 && pos.y == M - 1){
                return dist[pos.broken][pos.x][pos.y] + 1;
            }

            int nextdist = dist[pos.broken][pos.x][pos.y] + 1;
            for(int dir=0; dir<4; dir++){
                int nx = pos.x + DX[dir];
                int ny = pos.y + DY[dir];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }

                if(board[nx][ny] == 1 && dist[1][nx][ny] == -1 && pos.broken == 0){
                    dist[1][nx][ny] = nextdist;
                    q.add(new Pos(nx, ny, 1));
                }

                if(board[nx][ny] == 0 && dist[pos.broken][nx][ny] == -1){
                    dist[pos.broken][nx][ny] = nextdist;
                    q.add(new Pos(nx, ny, pos.broken));
                }

            }
        }
        return -1;
    }

    static public void initializeDistArray(){
        for (int[][] d : dist) {
            for (int[] row : d) {
                Arrays.fill(row, -1);
            }
        }
        dist[0][0][0] = 0;
        dist[1][0][0] = 0;
    }

}

class Pos{
    int x;
    int y;
    int broken;

    Pos(int x, int y, int broken){
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}