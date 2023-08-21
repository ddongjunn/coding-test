import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, S, cnt;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        if(S == 0){
            cnt--;  //양수인 부분수열만 cnt
        }
        System.out.println(cnt);
    }

    static void func(int n, int sum){
        if(n == N){
            if(sum == S){
                cnt++;
            }
            return;
        }

        func(n + 1, sum);
        func(n + 1, sum + arr[n]);
    }
}