import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] in = new int[N];
        for(int i = 0; i < N; i++) {
            in[i] = Integer.parseInt(br.readLine());
        }

        int[] fibonacciZero = new int[41];
        int[] fibonacciOne = new int[41];
        fibonacciZero[0] = 1;
        fibonacciZero[1] = 0;
        fibonacciOne[0] = 0;
        fibonacciOne[1] = 1;
        for(int i = 2; i <= 40; i++) {
            fibonacciZero[i] = fibonacciZero[i - 1] + fibonacciZero[i - 2];
            fibonacciOne[i] = fibonacciOne[i - 1] + fibonacciOne[i - 2];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(fibonacciZero[in[i]]).append(" ").append(fibonacciOne[in[i]]).append("\n");
        }
        System.out.println(sb.toString());
    }
}