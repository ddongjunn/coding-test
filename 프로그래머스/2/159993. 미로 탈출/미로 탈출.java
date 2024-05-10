import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static char[][] miro;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, -1, 0, 1};

    public int solution(String[] maps) {
        miro = new char[maps.length][maps[0].length()];
        Pos start = null;
        Pos labor = null;
        
        for(int x = 0; x < maps.length; x++){
            miro[x] = maps[x].toCharArray();

            for(int y = 0; y < miro[x].length; y++){                
                if(miro[x][y] == 'S'){
                    start = new Pos(x, y);
                }

                if(miro[x][y] == 'L'){
                    labor = new Pos(x, y);
                }
            }
        }
        int result1 = bfs(start, 'L'); 
        if(result1 == -1){
            return -1;
        }
        
        int result2 = bfs(labor, 'E');
        if(result2 == -1){
            return -1;
        }
        
        return result1 + result2;
    }
    
    public int bfs(Pos start, char target){
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(start.x, start.y, 0));

        boolean[][] isVisited = new boolean[miro.length][miro[0].length];
        isVisited[start.x][start.y] = true;

        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            int x = pos.x;
            int y = pos.y;
            int count = pos.dist;

            if(miro[x][y] == target){
                return count;
            }
    
            for(int dir = 0; dir < 4; dir++){
                int nx = pos.x + dx[dir];
                int ny = pos.y + dy[dir];

                if(nx >= miro.length || ny >= miro[0].length || nx < 0 || ny < 0){
                    continue;
                }
    
                if(miro[nx][ny] == 'X' || isVisited[nx][ny]){
                    continue;
                }

                isVisited[nx][ny] = true;
                queue.add(new Pos(nx, ny, count + 1));
            }
        }

        return -1;
    }
}

class Pos{
    int x;
    int y;
    int dist;

    Pos(int x, int y){
        this.x = x;
        this.y = y;
        this.dist = 0;
    }

    Pos(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}