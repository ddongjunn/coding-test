import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static final int[] DX = {1,0,-1,0};
    static final int[] DY = {0,1,0,-1};
    static int N;
    static int[][] matrix;
    static int count = 0;
    static ArrayList<Integer> areas = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                matrix[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(matrix[i][j] == 1){
                    count++;
                    matrix[i][j] = -1;
                    areas.add(bfs(i,j));
                }
            }
        }

        System.out.println(count);
        areas.stream().sorted().forEach(System.out::println);
    }

    public static int bfs(int i, int j){
        int cnt = 1;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(i, j));

        while(!q.isEmpty()){
            Pos pos = q.poll();

            for(int dir=0; dir<4; dir++){
                int nx = pos.x + DX[dir];
                int ny = pos.y + DY[dir];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(matrix[nx][ny] == -1 || matrix[nx][ny] == 0) continue;

                q.add(new Pos(nx, ny));
                matrix[nx][ny] = -1;
                cnt++;
            }
        }

        return cnt;
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