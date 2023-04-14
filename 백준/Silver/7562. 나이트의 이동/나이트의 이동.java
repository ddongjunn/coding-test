import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static final int[] dx = {1, 2,  2,  1, -1, -2, -2, -1};
    static final int[] dy = {2, 1, -1, -2, -2, -1,  1, 2,};
    static int[][] board;
    static Queue<Point> q;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tastCase = Integer.parseInt(br.readLine());
        for(int k=0; k<tastCase; k++){
            int boardLen = Integer.parseInt(br.readLine());

            board = new int[boardLen][boardLen];
            q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            Point startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //현재위치

            st = new StringTokenizer(br.readLine(), " ");
            Point endPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //목적지

            int distance = bfs(startPoint, endPoint);
            System.out.println(distance);
        }
    }

    public static int bfs(Point startPoint, Point endPoint){
        q = new LinkedList<>();
        q.add(startPoint);

        while(!q.isEmpty()){
            Point point = q.poll();
            if(point.x == endPoint.x && point.y == endPoint.y) return board[point.x][point.y]; 

            for(int dir=0; dir<dx.length; dir++){
                int nx = point.x + dx[dir]; 
                int ny = point.y + dy[dir];
                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) continue;
                if(board[nx][ny] > 0) continue;

                q.add(new Point(nx, ny));
                board[nx][ny] = board[point.x][point.y] + 1;
            }
        }
        return -1;
    }
}

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
