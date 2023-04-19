import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static final int[] DX = {1,0,-1,0};
    static final int[] DY = {0,1,0,-1};
    static int[][] matrix;
    static int M, N;
    static ArrayList<Integer> areas;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[M][N];

        int K = Integer.parseInt(st.nextToken());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1; y<y2; y++){
                for(int x=x1; x<x2; x++){
                    matrix[y][x] = 1;
                }
            }
        }

        areas = new ArrayList<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(matrix[i][j] == 0){
                    int count = bfs(i,j);
                    areas.add(count);
                }
            }
        }

        System.out.println(areas.size());
        areas.stream().sorted().forEach(num -> System.out.print(num + " "));

    }
    private static int bfs(int i, int j) {
        int count = 1;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(i, j));
        matrix[i][j] = 1;

        while(!q.isEmpty()){
            Pos pos = q.poll();
            for(int dir=0; dir<4; dir++){
                int nx = pos.x + DX[dir];
                int ny = pos.y + DY[dir];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(matrix[nx][ny] == 0){
                    q.add(new Pos(nx, ny));
                    matrix[nx][ny] = 1;
                    count++;
                }
            }
        }

        return count;
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
