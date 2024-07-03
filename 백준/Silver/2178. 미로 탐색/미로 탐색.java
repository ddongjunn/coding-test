import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<Pos> q = new LinkedList<>();
        
        visited[0][0] = true;
        distance[0][0] = 1;
        q.offer(new Pos(0, 0));

        while(!q.isEmpty()) {
            Pos pos = q.poll();
            int x = pos.x;
            int y = pos.y;

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if(visited[nx][ny] || board[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;
                q.offer(new Pos(nx, ny));
            }
        }
        System.out.println(distance[n - 1][m - 1]);
    }
}

class Pos {
    int x;
    int y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}