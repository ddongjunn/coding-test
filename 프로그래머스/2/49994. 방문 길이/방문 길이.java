import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        boolean[][][] visit = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        int ans = 0;
        for(int i = 0; i < dirs.length(); i++) {
            int dir = switch (String.valueOf(dirs.charAt(i))) {
                case "U" -> 0;
                case "R" -> 1;
                case "D" -> 2;
                case "L" -> 3;
                default -> -1;
            };

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) {
                continue;
            }

            if(!visit[nx][ny][(dir + 2) % 4] && !visit[x][y][dir]) {
                visit[nx][ny][(dir + 2) % 4] = true;
                visit[x][y][dir] = true;
                ans++;
            }

            x = nx;
            y = ny;
            
        }
        
        return ans;
    }
}