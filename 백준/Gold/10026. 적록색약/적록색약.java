import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static char[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int normal = getComponentCount();
        flipColors();
        int redGreen = getComponentCount();

        System.out.println(normal + " " + redGreen);
    }

    static int getComponentCount() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        visit = new boolean[n][n];
        return count;
    }

    static void flipColors() {
        for (char[] row : board) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 'R') {
                    row[j] = 'G';
                }
            }
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        char color = board[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (!visit[nx][ny] && board[nx][ny] == color) {
                dfs(nx, ny);
            }
        }
    }
}
