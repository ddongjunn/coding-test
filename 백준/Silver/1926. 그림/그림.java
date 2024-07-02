import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
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
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        int mx = 0; // 넓이
        int num = 0; // 그림 갯수
        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(board[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                Deque<Pos> q = new ArrayDeque<>();
                q.add(new Pos(i, j));
                visited[i][j] = true;
                num++;

                int area = 0;
                while(!q.isEmpty()) {
                    area++;
                    Pos pos = q.poll();
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = pos.x + dx[dir];
                        int ny = pos.y + dy[dir];

                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                            continue;
                        }

                        if(visited[nx][ny] || board[nx][ny] == 0) {
                            continue;
                        }

                        q.offer(new Pos(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
                mx = Math.max(mx, area);
            }
        }
        System.out.println(num);
        System.out.println(mx);
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