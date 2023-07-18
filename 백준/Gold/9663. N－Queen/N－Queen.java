import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static int N;
    static int cnt = 0;
    static boolean[] isUsed1;
    static boolean[] isUsed2;
    static boolean[] isUsed3;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isUsed1 = new boolean[N + 1];
        isUsed2 = new boolean[N * 2];
        isUsed3 = new boolean[N * 2];

        Main main = new Main();
        main.solution(0);

        System.out.println(cnt);
    }

    public void solution(int cur){
        if(cur == N){
            cnt++;
            return;
        }

        for(int i=1; i<=N; i++){
            if(isUsed1[i] || isUsed2[i + cur] || isUsed3[i - cur + N - 1]){
                continue;
            }

            isUsed1[i] = true;
            isUsed2[i + cur] = true;
            isUsed3[i - cur + N - 1] = true;

            solution(cur + 1);

            isUsed1[i] = false;
            isUsed2[i + cur] = false;
            isUsed3[i - cur + N - 1] = false;
        }
    }
}