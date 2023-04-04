import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int c = 0;
    static int n = 0;
    static int answer = Integer.MIN_VALUE;

    static void solution(int L, int sum, int[] arr){
        if(sum > c) return;

        if(L == n){ //바둑이 마릿수가 n과 같아질때
            answer = Math.max(answer, sum); //c가 sum보다 작으면 두 수를비교
        }else{
            solution(L+1, sum+arr[L], arr);
            solution(L+1, sum, arr);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();    
        StringTokenizer st = new StringTokenizer(str, " ");
        
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[c];
        for(int i=0;i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution(0, 0, arr);
        System.out.println(answer);
    }

}

