import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int k;
    static int[] in, out;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            in = new int[k]; 
            out = new int[6];
            isUsed = new boolean[k];
            for(int i=0; i<k; i++){
                in[i] = Integer.parseInt(st.nextToken());
            }

            if(k == 0){
                break;
            }

            Arrays.sort(in);
            func(0, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void func(int start, int depth){
        if(depth == 6){
            for(int n : out){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<k; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                out[depth] = in[i];
                func(i + 1, depth + 1);
                isUsed[i] = false;
            }
        }
    }
}