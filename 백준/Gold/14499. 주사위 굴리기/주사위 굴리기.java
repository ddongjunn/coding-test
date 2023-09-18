import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    //동 서 북 남
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    //    [2]
    // [4][1][3]
    //    [5]
    //    [6]
    static int[] dice = new int[7];

    static int n, m, x, y;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //ROW
        m = Integer.parseInt(st.nextToken());   //COL
        map = new int[n][m];

        x = Integer.parseInt(st.nextToken());   //COL
        y = Integer.parseInt(st.nextToken());   //ROW

        int k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            move(Integer.parseInt(st.nextToken()));
        }
    }

    private static void move(int dir) {
        int nx = x + dx[dir - 1]; 
        int ny = y + dy[dir - 1];
        
        if(nx < 0 || nx >= n|| ny < 0 || ny >= m){
            return;
        } 

        roll(dir);
        score(nx, ny);
        x = nx; y = ny;
    }

    private static void roll(int dir) {
        int tmp = dice[1];
        switch(dir){
            case 1:
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
                break;
            case 2:
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 4:
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }       
    }

    private static void score(int nx, int ny) {
        if(map[nx][ny] == 0){
            map[nx][ny] = dice[6];
        }else{
            dice[6] = map[nx][ny];
            map[nx][ny] = 0;
        }
        System.out.println(dice[1]);
    }
}