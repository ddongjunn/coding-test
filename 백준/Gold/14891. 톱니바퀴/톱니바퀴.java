import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static final int ROW = 4;
    static final int COL = 8;
    static int[][] gears = new int[ROW][COL];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < ROW; i++){
            String str = br.readLine();
            for(int j = 0; j < COL; j++){
                gears[i][j] = str.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            turn(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
        }
        
        int answer = 0;
        for(int i = 0; i < ROW; i++){
            if(gears[i][0] == 1){
                answer += (int) (1 << i);
            }
        }
        System.out.println(answer);
    }

    private static void turn(int gear, int dir) {
        int[] dirs = new int[ROW];
        dirs[gear] = dir;

        int idx = gear;
        while(idx > 0 && gears[idx][6] != gears[idx-1][2]){
            dirs[idx-1] = -dirs[idx];
            idx--;
        }

        idx = gear;
        while(idx < 3 && gears[idx][2] != gears[idx+1][6]){
            dirs[idx+1] = -dirs[idx];
            idx++;
        }

        for(int i = 0; i < ROW; i++){
            rotate(i, dirs[i]);
        }
        
    }

    private static void rotate(int gear, int dir) {
        if(dir == 1){
            int last = gears[gear][COL - 1];
            System.arraycopy(gears[gear], 0, gears[gear], 1, COL - 1);
            gears[gear][0] = last;
        }else if(dir == -1){
            int first = gears[gear][0];
            System.arraycopy(gears[gear], 1, gears[gear], 0, COL - 1);
            gears[gear][COL - 1] = first;
        }
    }

}