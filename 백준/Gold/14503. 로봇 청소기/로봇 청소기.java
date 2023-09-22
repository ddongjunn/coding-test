import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    //북 동 남 서 
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while(true){
            if(map[x][y] == 0){
                map[x][y] = -1;
                ans++;
            }

            boolean cleaned = false;
            for(int dir = 0; dir < 4; dir++){
                d = (d + 3) % 4;
                if(map[x + dx[d]][y + dy[d]] == 0){
                    cleaned = true;
                    x += dx[d];
                    y += dy[d];
                    break;
                }
            }

            if(cleaned){
                continue;
            }

            if(map[x - dx[d]][y - dy[d]] == 1){
                break;
            }
            x -= dx[d];
            y -= dy[d];
        }
        System.out.println(ans);
    }
}