import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static int[] inArr, outArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inArr = new int[N];
        outArr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            inArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inArr);
        solution(0, 0);
        System.out.println(sb.toString());
    }

    public static void solution(int start, int depth){
        if(depth == M){
            for(int n : outArr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for(int i=start; i<N; i++){
            if(prev != inArr[i]){
                prev = inArr[i];
                outArr[depth] = inArr[i];
                solution(i, depth + 1);
            }
        }
    }
}