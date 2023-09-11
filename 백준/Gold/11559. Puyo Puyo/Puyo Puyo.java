import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main{
    final static int ROW = 12;
    final static int COL = 6;
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    static char[][] map = new char[ROW][COL];
    static Queue<Puyo> q = new LinkedList<>();
    static int answer = 0;
    static boolean flag;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < ROW; i++){
            map[i] = br.readLine().toCharArray();
        }

        while(game());
        System.out.println(answer);
    }

    private static boolean game() {
        flag = false;
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(map[i][j] != '.'){
                    q.offer(new Puyo(i, j, map[i][j]));
                    findColor();
                }
            }
        }

        gravity();
        
        if(flag){
            answer++;
            return true;
        }else{
            return false;
        }
    }

    private static void gravity() {
        Queue<Character> qu = new LinkedList<>();
        for(int i = 0; i < COL; i++){
            for(int j = ROW - 1; j >= 0; j--){
                if(map[j][i] != '.'){
                    qu.add(map[j][i]);
                    map[j][i] = '.';
                } 
            }

            int h = ROW - 1;
            while(!qu.isEmpty()){
                map[h--][i] = qu.poll();
            }
        }
    }

    private static void findColor() {
        boolean[][] isVisited = new boolean[ROW][COL];
        List<Puyo> tmp = new ArrayList<>();

        Puyo p = q.peek();
        isVisited[p.x][p.y] = true;
        tmp.add(p);

        while(!q.isEmpty()){
            Puyo puyo = q.poll();

            for(int dir = 0; dir < 4; dir++){
                int nx = puyo.x + dx[dir];
                int ny = puyo.y + dy[dir];

                if(nx < 0 || nx >= ROW || ny < 0  || ny >= COL){
                    continue;
                }
                
                if(isVisited[nx][ny]){
                    continue;
                }

                if(map[nx][ny] == puyo.color){
                    q.offer(new Puyo(nx, ny, puyo.color));
                    tmp.add(new Puyo(nx, ny, puyo.color));
                    isVisited[nx][ny] = true;
                }
           }
        }

        if(tmp.size() >= 4){
            flag = true;
            for(Puyo pu : tmp){
                map[pu.x][pu.y] = '.';
            }
        }
        
    }
}

class Puyo{
    int x;
    int y;
    char color;

    Puyo(int x, int y, char color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
}