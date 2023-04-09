import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }

        int[][] dist = new int[n][m];
        for (int[] is : dist) {
            Arrays.fill(is, -1);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        dist[0][0] = 1;
        while(!q.isEmpty()){
            Pair pair = q.poll();
            for(int dir=0; dir<4; dir++){
                int nx = pair.x + dx[dir];
                int ny = pair.y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] >= 0 || board[nx][ny] != 1) continue;

                dist[nx][ny] = dist[pair.x][pair.y]+1;
                q.add(new Pair(nx, ny));
            }
        }
        System.out.println(dist[n-1][m-1]);
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

