import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        for(int[] r : rectangle) {
            fill(2 * r[0], 2 * r[1], 2 * r[2], 2 * r[3]);
        }
        
        dfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer / 2;
    }
    
    public void fill(int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(map[i][j] == 2) {
                    continue;
                }
                map[i][j] = 2;
                
                if(i == x1 || j == y1 || i == x2 || j == y2) {
                    map[i][j] = 1;
                }
            }
        }
    }
    
    public void dfs(int startX, int startY, int targetX, int targetY) {
        boolean[][] visited = new boolean[101][101];
        visited[startX][startY] = true;
        
        Queue<Pos> queue = new LinkedList();
        queue.offer(new Pos(startX, startY, 0));
        
        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            
            if(pos.x == targetX && pos.y == targetY) {
                answer = pos.cost;
                return;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = pos.x + dx[dir];
                int ny = pos.y + dy[dir];
                
                if(nx < 0 || ny < 0 || nx >= 101 || ny >= 101) {
                    continue;
                }
                
                if(visited[nx][ny] || map[nx][ny] != 1) {
                    continue;
                }
                
                queue.offer(new Pos(nx, ny, pos.cost + 1));
                visited[nx][ny] = true;
            }
        }
    }
}

class Pos {
    int x;
    int y;
    int cost;
    Pos(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}