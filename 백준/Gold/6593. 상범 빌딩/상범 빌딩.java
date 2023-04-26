import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static final int[] DX = {1,-1,0,0,0,0};
    static final int[] DY = {0,0,1,-1,0,0};
    static final int[] DZ = {0,0,0,0,1,-1};
    static int L, R, C;
    static char[][][] board;
    static boolean[][][] visit;
    static int result = 0;
    static Queue<Pos> q;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 || R == 0 || C == 0){
                break;
            }

            q = new LinkedList<>();
            board = new char[L][R][C];
            visit = new boolean[L][R][C];
            for(int z=0; z<L; z++){
                for(int x=0; x<R; x++){
                    String str = br.readLine();
                    for(int y=0; y<C; y++){
                        char ch = str.charAt(y);
                        board[z][x][y] = ch;

                        if(ch == '#'){
                            visit[z][x][y] = true;
                        }

                        if(ch == 'S'){
                            q.add(new Pos(x, y, z, 0));
                            board[z][x][y] = '#';
                            visit[z][x][y] = true;
                        }
                    }
                }
                br.readLine();
            }

            bfs();
            if(result > 0){
                System.out.println("Escaped in " + result +" minute(s).");
            }else{
                System.out.println("Trapped!");
            }
        }
    }

    public static void bfs(){
        result = 0;
        while(!q.isEmpty()){
            Pos pos = q.poll();

            for(int dir=0; dir<6; dir++){
                int nz = pos.z + DZ[dir];
                int nx = pos.x + DX[dir];
                int ny = pos.y + DY[dir];

                if(nz < 0 || nx < 0 || ny < 0 || nz >= L || nx >= R || ny >= C){
                    continue;
                }

                if(board[nz][nx][ny] == '#' || visit[nz][nx][ny]){
                    continue;
                }

                if(board[nz][nx][ny] == 'E'){
                    result = pos.cnt + 1;
                    return;
                }

                q.add(new Pos(nx, ny, nz, pos.cnt + 1));
                visit[nz][nx][ny] = true;
            }
        }
    }
}

class Pos{
    int x;
    int y;
    int z;
    int cnt;

    Pos(int x, int y, int z, int cnt){
        this.x = x;
        this.y = y;
        this.z = z;
        this.cnt = cnt;
    }
}