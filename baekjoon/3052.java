import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean chk[] = new boolean[42];
        for(int i = 0; i < 10; i++){
            chk[Integer.parseInt(br.readLine()) % 42] = true;
        }

        int count = 0;
        for(int i = 0; i < chk.length; i++){
            if(chk[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
