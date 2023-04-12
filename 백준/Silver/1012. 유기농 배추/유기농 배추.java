import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs(int[][] field, boolean[][] visit){
        Queue<Pair> q = new LinkedList<>();
        int answer = 0;
        for(int i=0; i<field.length; i++){
            for(int j=0; j<field[i].length; j++){
                if(field[i][j] == 0 || visit[i][j]) continue;
                q.add(new Pair(i, j));
                visit[i][j] = true;
                answer++;
                while(!q.isEmpty()){
                    Pair pair = q.poll();
                    for(int dir=0; dir<4; dir++){
                        int nx = pair.x + dx[dir];
                        int ny = pair.y + dy[dir];
                        
                        if(nx < 0 || ny < 0 || nx >= field.length || ny >= field[i].length) continue;
                        if(visit[nx][ny] || field[nx][ny] != 1) continue;
                        visit[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int testCaseCnt = Integer.parseInt(st.nextToken());
        for(int t=0; t<testCaseCnt; t++){
            st = new StringTokenizer(br.readLine(), " ");
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int cabbageCnt = Integer.parseInt(st.nextToken());

            int[][] field = new int[width][height];
            boolean[][] visit = new boolean[width][height];
            for(int i=0; i<cabbageCnt; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }
            bfs(field, visit);
        }
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
