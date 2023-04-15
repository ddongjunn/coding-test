import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int w, h;
    static char[][] map;
    static boolean[][] visit;
    static Queue<Pos> person;
    static Queue<Pos> fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            map = new char[h][w];
            visit = new boolean[h][w];
            person = new LinkedList<>();
            fire = new LinkedList<>();            

            for(int i=0; i<h; i++){
                map[i] = br.readLine().toCharArray();
                for(int j=0; j<w; j++){
                    //상근이
                    if(map[i][j] == '@'){
                        visit[i][j] = true;
                        map[i][j] = '.';
                        person.offer(new Pos(i, j, 0));
                    }

                    //불
                    if(map[i][j] == '*'){
                        fire.offer(new Pos(i, j));
                    }
                }
            }
            int answer = bfs();
            sb.append((answer != Integer.MAX_VALUE ? answer : "IMPOSSIBLE")).append("\n");
        }
        System.out.println(sb);
    }
    
    static int bfs(){
        int answer = Integer.MAX_VALUE;
        while(!person.isEmpty()){
            /**
             * 불을 이동시켜 불이 붙으려는 칸으로 이등할 수 없도록 처리
             * 이때, 현재 시간의 불들을 전부 이동시켜야 하므로 현재 큐에 들어있는 같은 시간대의 불들을 전부 이동 시키기 위해 fire의 size만큼 bfs수행
             */

             //불 이동
            int size = fire.size();
            while(size-- > 0){
                Pos pos = fire.poll();

                for(int dir=0; dir<4; dir++){
                    int nx = pos.x + dx[dir];
                    int ny = pos.y + dy[dir];
                    
                    if(nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] != '.') continue;
                    
                    map[nx][ny] = '*';
                    fire.offer(new Pos(nx, ny));
                }
            }            
            
            //상근이 이동
            size = person.size();
            while(size-- > 0){
                Pos pos = person.poll();
                //맵의 경계에 있다면 다음에 밖으로 탈출이 가능하다.
                if(pos.x == 0 || pos.y == 0 || pos.x == h - 1 || pos.y == w - 1){
                    answer = pos.time + 1;
                    return answer;
                }

                for(int dir=0; dir<4; dir++){
                    int nx = pos.x + dx[dir];
                    int ny = pos.y + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if(map[nx][ny] != '.' || visit[nx][ny]) continue;

                    visit[nx][ny] = true;
                    person.offer(new Pos(nx, ny, pos.time + 1));
                }
            }
        }
        return answer;
    }
}

class Pos{
    int x;
    int y;
    int time;

    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }

    Pos(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

