import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int[][] eggs;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        eggs = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);
        System.out.println(answer);
    }
    private static void solution(int idx, int cnt) {
        if(idx == N){
            answer = Math.max(answer, cnt);
            return;
        }

        //손으로 든 계란이 이미 깨졌거나, 모든 계란이 이미 다 깨져 있는 경우
        if(eggs[idx][0] <= 0 || cnt == N - 1){
            solution(idx + 1, cnt);
            return;
        }

        int newCnt = cnt;
        for(int i=0; i<N; i++){

            //손으로 든 계란과 부딪히려고 하는 계란이 같은 경우 or 부딪혀 보려고 하는 계란이 이미 깨진 경우
            if(idx == i || eggs[i][0] <= 0){
                continue;
            }

            hitEgg(idx, i);

            if(eggs[idx][0] <= 0){
                cnt++;
            }

            if(eggs[i][0] <= 0){
                cnt++;
            }

            solution(idx + 1, cnt);
            recorveryEgg(idx, i);
            cnt = newCnt;
        }
    }

    private static void hitEgg(int source, int target) {
        eggs[source][0] -= eggs[target][1];
        eggs[target][0] -= eggs[source][1]; 
    }

    private static void recorveryEgg(int source, int target) {
        eggs[source][0] += eggs[target][1];
        eggs[target][0] += eggs[source][1]; 
    }
}