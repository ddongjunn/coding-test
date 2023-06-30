import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long answer = func(a, b, c);
        System.out.println(answer);
    }

    public static long func(long a, long b, long m){
        if(b == 0){
            return 1;
        }
        long val = func(a, b / 2, m);
        val = val * val % m;
        if(b % 2 == 0){
            return val;
        }
        return val * a % m;
    }
}