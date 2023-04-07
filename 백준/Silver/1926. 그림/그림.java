import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int[] dx = {1,0,-1,0};
        int[] dy= {0,1,0,-1};

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int mx = 0; //가장 넓은 그림의 넓이
        int num = 0; //그림의 개수

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0 || visit[i][j]) continue;

                num++;
                Queue<Pair> queue = new LinkedList<>();
                queue.add(new Pair(i, j));
                visit[i][j] = true;
                int area = 0;

                while(!queue.isEmpty()){
                    area++;
                    Pair node = queue.poll();
                    for(int dir=0; dir<4; dir++){
                        int nx = node.x + dx[dir];
                        int ny = node.y + dy[dir];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(visit[nx][ny] || board[nx][ny] != 1) continue;
                        
                        visit[nx][ny] = true;
                        queue.add(new Pair(nx, ny));
                    }
                }
                mx = Math.max(mx, area);
            }
        }
        System.out.println(num);
        System.out.println(mx);
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

