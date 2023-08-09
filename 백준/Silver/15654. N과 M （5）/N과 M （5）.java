import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static int[] inArr, outArr;
    static boolean[] isVisited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inArr = new int[N];
        outArr = new int[N];
        isVisited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            inArr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(inArr);

        solution(0, 0);
    }

    public static void solution(int start, int depth){
        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(outArr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                outArr[depth] = inArr[i];
                solution(i + 1, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}