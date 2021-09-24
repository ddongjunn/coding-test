
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int max = 0;
        double score[] = new double[N];
        for(int i = 0; i < score.length; i++){
            score[i] = Integer.parseInt(st.nextToken());

            if(max < score[i]){
                max = (int) score[i];
            }
        }

        double sum = 0;
        for(int i = 0; i < score.length; i++){
            score[i] = score[i] / max * 100;
            sum += score[i];
        }

        System.out.println((double)sum / score.length);

    }
}
