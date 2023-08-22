import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static final int N = 5;
    static int answer = 0;
    static char[][] classroom;
    static boolean[] isVisited;
    static int[] selected;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        classroom = new char[N][N];
        isVisited = new boolean[N*N];
        selected = new int[7];

        for(int i=0; i<5; i++){
            classroom[i] = br.readLine().toCharArray();
        }

        combination(0, 0, 0);
        System.out.println(answer);
    }

    private static void combination(int start, int depth, int dasom) {
        if(depth == 7){
            if(dasom >= 4){
                bfs();
            }
            return;
        }

        for(int i=start; i<25; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                selected[depth] = i;
                if(classroom[i/N][i%N] == 'S'){
                    combination(i + 1, depth + 1, dasom + 1);
                }else{
                    combination(i + 1, depth + 1, dasom);
                }
                isVisited[i] = false;
            }
        }

    }

    private static void bfs() {
        final int dx[] = {1, 0, -1, 0};
        final int dy[] = {0, 1, 0, -1};
        boolean visted[][] = new boolean[N][N];
        int cnt = 1;

        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(selected[0]/5, selected[0]%5));
        visted[selected[0]/5][selected[0]%5] = true;
        while(!q.isEmpty()){
            Pos pos = q.poll();
            int x = pos.x;
            int y = pos.y;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i]; 

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5){
                    continue;
                } 

                if(visted[nx][ny]){
                    continue;
                }

                if(!isVisited[nx*5+ny]){
                    continue;
                }
                
                cnt++;
                visted[nx][ny] = true;
                q.add(new Pos(nx, ny));
            }
        }

        if(cnt == 7){
            answer++;
        }
    }
}

class Pos{
    int x;
    int y;

    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}