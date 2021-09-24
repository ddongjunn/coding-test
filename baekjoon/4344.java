import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int length = Integer.parseInt(st.nextToken());

            double sum = 0;

            int arr[] = new int[length];
            for(int j = 0; j < arr.length; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }

            double avg = sum / length;

            double count = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] > avg){
                    count++;
                }
            }

            System.out.printf("%.3f%%%n",(count / length) * 100 );
        }
    }
}
