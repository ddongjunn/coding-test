import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] jihoon, fire;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        jihoon = new int[R][C];
        fire = new int[R][C];

        for(int i = 0; i < R; i++){
            Arrays.fill(jihoon[i], -1);
            Arrays.fill(fire[i], -1);
        }

        Queue<int[]> qJ = new LinkedList<>();
        Queue<int[]> qF = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                if(map[i][j] == 'J') {
                    qJ.add(new int[]{i, j});
                    jihoon[i][j] = 0;
                }

                if(map[i][j] == 'F') {
                    qF.offer(new int[]{i, j});
                    fire[i][j] = 0;
                }
            }
        }

        findEscape(qJ, qF);
    }

    public static void findEscape(Queue<int[]> qJ, Queue<int[]> qF){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!qF.isEmpty()) {
            int[] cur = qF.poll();
            int x = cur[0];
            int y = cur[1];

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(isRange(nx, ny)) {
                    continue;
                }

                if(map[nx][ny] == '#' || fire[nx][ny] >= 0) {
                    continue;
                }

                qF.offer(new int[]{nx, ny});
                fire[nx][ny] = fire[x][y] + 1;
            }
        }

        while(!qJ.isEmpty()) {
            int[] cur = qJ.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = jihoon[x][y] + 1;

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(isRange(nx, ny)) {
                    System.out.println(dist);
                    System.exit(0);
                }
                
                if(isFire(nx, ny, dist)) {
                    continue;
                }

                if(map[nx][ny] == '#' || jihoon[nx][ny] >= 0) {
                    continue;
                }

                qJ.offer(new int[]{nx, ny});
                jihoon[nx][ny] = dist;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static boolean isRange(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C;
    }
    
    public static boolean isFire(int x, int y, int dist) {
        return fire[x][y] <= dist && fire[x][y] != -1;
    }
}