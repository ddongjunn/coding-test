import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static final int[] dx = {1, 0, -1, 0};
    public static final int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        Queue<Pos> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[row][col];
        int[][] distance = new int[row][col];

        q.offer(new Pos(0, 0));
        isVisited[0][0] = true;
        distance[0][0] = 1;

       while (!q.isEmpty()) {
            Pos pos = q.poll();
            int x = pos.x;
            int y = pos.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }

                if (isVisited[nx][ny] || maps[nx][ny] == 0) {
                    continue;
                }

                isVisited[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;

                if (nx == row - 1 && ny == col - 1) {
                    return distance[nx][ny];
                }

                q.offer(new Pos(nx, ny));
            }
        }
        return -1; // 목표 지점에 도달할 수 없는 경우
    }
}

class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) { 
        this.x = x;
        this.y = y;
    }
}
