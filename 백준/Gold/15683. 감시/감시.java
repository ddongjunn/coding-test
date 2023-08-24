import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    private static final int dx[] = {1, 0, -1 ,0};
    private static final int dy[] = {0, 1, 0, -1};
    private static int N, M, answer;
    private static int room[][];
    private static int room2[][];
    private static List<Pair> cctv;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        room2 = new int[N][M];
        cctv = new ArrayList<>();

        for(int x=0; x<N; x++){
            st = new StringTokenizer(br.readLine());
            for(int y=0; y<M; y++){
                int num = Integer.parseInt(st.nextToken());
                room[x][y] = num;

                if(num != 0 && num != 6){
                    cctv.add(new Pair(x, y));
                }

                if(num == 0){
                    answer++;
                }
            }
        }
        
        findBlindSpot();
        System.out.println(answer);
        
    }

    private static void findBlindSpot() {
        for(int tmp = 0; tmp < (1 << (2 * cctv.size())); tmp++){
            for(int x=0; x<N; x++){
                for(int y=0; y<M; y++){
                    room2[x][y] = room[x][y];
                }
            }

            int brute = tmp;
            for(int i = 0; i < cctv.size(); i++){
                int dir = brute % 4;
                brute /= 4;
                int x = cctv.get(i).x;
                int y = cctv.get(i).y;

                switch(room[x][y]){
                    case 1 :
                        upd(x, y, dir);
                        break;

                    case 2 :
                        upd(x, y, dir);
                        upd(x, y, dir+2);
                        break;

                    case 3 :
                        upd(x, y, dir);
                        upd(x, y, dir+1);
                        break;

                    case 4 :
                        upd(x, y, dir);
                        upd(x, y, dir+1);
                        upd(x, y, dir+2);
                        break;

                    case 5 : 
                        upd(x, y, dir);
                        upd(x, y, dir+1);
                        upd(x, y, dir+2);
                        upd(x, y, dir+3);
                        break;
                }                
            }

            int val = 0;
            for(int x=0; x<N; x++){
                for(int y=0; y<M; y++){
                    if(room2[x][y] == 0){
                       val++; 
                    }
                }
            }
            answer = Math.min(answer, val);
        }


    }

    private static void upd(int x, int y, int dir) {
        dir %= 4;
        
        while(true){
            x += dx[dir];
            y += dy[dir];

            if(oob(x, y) || room2[x][y] == 6){
                return;
            }   

            if(room2[x][y] == 7){
                continue;
            }

            room2[x][y] = 7;
        }
    }

    private static boolean oob(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}

class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}