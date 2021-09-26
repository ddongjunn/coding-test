import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(test(Integer.parseInt(br.readLine())));

    }

    public static int test(int N){
        int cnt = 0; //한수 카운팅

        if(N < 100){
            return N;
        }else{
            cnt = 99;
            if(N == 1000){
                N = 999;
            }
        }

        for(int i = 100; i <= N; i++){
            int hun = i / 100;
            int ten = (i / 10) % 10;
            int one = i % 10;

            if((hun - ten) == (ten - one)){ //각 자릿수가 수열을 이루면
                cnt++;
            }
        }

        return cnt;
    }
}
