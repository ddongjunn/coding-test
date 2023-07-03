import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, r, c));
    }

    public static int solution (int N, int r, int c){
        if(N == 0){
            return 0;
        }
        int half = 1 << N-1;
        
        if(r < half && c < half){
            return solution(N-1, r, c);
        }

        if(r < half && c >= half){
            return half * half + solution(N-1, r, c-half);
        }

        if(r >= half && c < half){
            return 2 * half * half + solution(N-1, r-half, c);
        }

        return 3 * half * half + solution(N-1, r-half, c-half);
    }
}