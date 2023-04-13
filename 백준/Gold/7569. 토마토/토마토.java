import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] matrix;
    static int row, column, height;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        matrix = new int[height][row][column];

        for(int z=0; z<height; z++){
            for(int x=0; x<row; x++){
                    st = new StringTokenizer(br.readLine()," ");
                for(int y=0; y<column; y++){
                    int tomatoStatus = Integer.parseInt(st.nextToken());
                    
                    matrix[z][x][y] = tomatoStatus;
                    if(tomatoStatus == 1){
                        q.add(new Point(z, x, y));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        while(!q.isEmpty()){
            Point point = q.poll();
            for(int i=0; i<6; i++){
                int nz = point.z + dz[i];
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                
                if(checkPoint(nz, nx, ny)){
                    q.add(new Point(nz, nx, ny));
                    matrix[nz][nx][ny] = matrix[point.z][point.x][point.y] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int z=0; z<height; z++){
            for(int x=0; x<row; x++){
                for(int y=0; y<column; y++){
                    if(matrix[z][x][y] == 0) return -1; 
                    result = Math.max(result, matrix[z][x][y]);
                }
            }
        }

        if(result == 1) return 0;
        else return result - 1;
    }

    public static boolean checkPoint(int nz, int nx, int ny){
        if(nx < 0 || ny < 0 || nz < 0 || nx >= row || ny >= column || nz >= height) return false;
        if(matrix[nz][nx][ny] == 0) return true;
        return false;
    }
}

class Point{
    int z;
    int x;
    int y;

    Point(int z, int x, int y){
        this.z = z;
        this.x = x;
        this.y = y;
    }
}
