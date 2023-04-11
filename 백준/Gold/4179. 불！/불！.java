import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        Queue<Pair> fire = new LinkedList<>();
        int[][] fireDist = new int[R][C];
        for (int[] is : fireDist) {
            Arrays.fill(is, -1);
        }

        Queue<Pair> person = new LinkedList<>();
        int[][] personDist = new int[R][C];
        for (int[] is : personDist) {
            Arrays.fill(is, -1);
        }

        String[][] maze = new String[R][C];
        for(int i=0; i<R; i++){
            String input = br.readLine();
            for(int j=0; j<C; j++){
                String s = Character.toString(input.charAt(j));
                maze[i][j] = s;
                if(s.equals("F")){
                    fire.add(new Pair(i, j));
                    fireDist[i][j] = 0;
                }
                if(s.equals("J")){ 
                    person.add(new Pair(i, j));
                    personDist[i][j] = 0;
                }
            }
        }

        //불에 대한 BFS
        while(!fire.isEmpty()){ 
            Pair pair = fire.poll();
            for(int dir=0; dir<4; dir++){
                int nx = pair.x + dx[dir];
                int ny = pair.y + dy[dir];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(maze[nx][ny].equals("#") || fireDist[nx][ny] >= 0) continue;
                fireDist[nx][ny] = fireDist[pair.x][pair.y] + 1;
                fire.add(new Pair(nx, ny));
            }
        }

        //지훈이에 대한 BFS
        while(!person.isEmpty()){
            Pair pair = person.poll();
            for(int dir=0; dir<4; dir++){
                int nx = pair.x + dx[dir];
                int ny = pair.y + dy[dir];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C){ //범위를 벗어났다는 것은 탈출성공. 큐에 거리순으로 들어가기 때문에 최초에 탈출한 시간
                    System.out.println(personDist[pair.x][pair.y]+1);
                    System.exit(0);
                }
                if(personDist[nx][ny] >= 0 || maze[nx][ny].equals("#")) continue;
                if(fireDist[nx][ny] != -1 && fireDist[nx][ny] <= personDist[pair.x][pair.y]+1) continue;
                personDist[nx][ny] = personDist[pair.x][pair.y] + 1;
                person.add(new Pair(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
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