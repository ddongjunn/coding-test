import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static final int dx[] = {1, 0, -1, 0};  // [1][0]: 아래, [0][1]: 오른쪽, [-1][0]: 위, [0][-1]: 왼쪽
    static final int dy[] = {0, 1, 0, -1};
    static int[][] board = new int[101][101];
    static Deque<Pair> dq = new LinkedList<>();
    static Queue<PairDir> switchDir = new LinkedList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 2;
        }
        
        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            switchDir.offer(new PairDir(X, C));
        }
        
        dq.offerFirst(new Pair(1, 1));
        int dir = 1;
        int second = 0;
        while(true){          
            dir %= 4;

            Pair cur = dq.peekFirst();
            board[cur.x][cur.y] = 1;
            second++;

            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];

            if(nx < 1 || nx > N || ny < 1 || ny > N){
                break;
            }

            if(board[nx][ny] == 1){
                break;
            }

            if(board[nx][ny] != 2){
                Pair tail = dq.pollLast();
                board[tail.x][tail.y] = 0; 
            }        
        
            if (!switchDir.isEmpty()) {
                PairDir sd = switchDir.peek();
                if (sd.second == second) {
                    if (sd.direction == 'L'){
                        dir += 1;
                    }else if(sd.direction == 'D'){
                        dir += 3;
                    }
                    switchDir.poll();
                }      
            }

            dq.offerFirst(new Pair(nx, ny));
        }
        System.out.println(second);
    }
}

class Pair{
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class PairDir{
    int second;
    char direction;
    
    PairDir(int second, char direction) {
        this.second = second;
        this.direction = direction;
    }
}