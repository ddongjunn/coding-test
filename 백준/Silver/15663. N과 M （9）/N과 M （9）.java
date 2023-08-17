import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static int[] inArr, outArr;
    static LinkedHashSet<String> answer;
    static boolean[] isVisit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inArr = new int[N];
        outArr = new int[M];
        isVisit = new boolean[N];
        answer = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            inArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inArr);
        solution(0, 0);
        answer.forEach(System.out::println);
    }

    public static void solution(int start, int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int n : outArr){
                sb.append(n).append(" ");
            }
            answer.add(sb.toString());
            return;
        }

        for(int i=0; i<N; i++){
            if(isVisit[i]){
                continue;
            }
            
            isVisit[i] = true;
            outArr[depth] = inArr[i];
            solution(i, depth + 1);
            isVisit[i] = false;
        }
    }
}