import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static final int[] dx = {1,0,-1,0};
    static final int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        Queue<Pair> q = new LinkedList<>();
        int[][] board = new int[N][M];
        int[][] dist = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) q.add(new Pair(i, j));
                if(board[i][j] == 0) dist[i][j] = -1;
            }
        }

        while(!q.isEmpty()){
            Pair pair = q.poll();
            for(int dir=0; dir<4; dir++){
                int nx = pair.x + dx[dir];
                int ny = pair.y + dy[dir];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[pair.x][pair.y]+1;
                q.add(new Pair(nx, ny));
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(dist[i][j] == -1){
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, dist[i][j]);
            }
        }
        System.out.println(answer);
    }
}

class Pair{
    int x;
    int y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}