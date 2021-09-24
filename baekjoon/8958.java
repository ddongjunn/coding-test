import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str[] = new String[N];
        for(int i = 0 ; i < str.length; i++){
            str[i] = br.readLine();
        }

        for(int i = 0; i < str.length; i++){
            int score = 0;
            int count = 0;

            for(int j = 0; j < str[i].length(); j++){
                if(str[i].charAt(j) == 'O'){
                    count++;
                }else{
                    count = 0;
                }
                score += count;
            }
            System.out.println(score);
        }

    }
}
