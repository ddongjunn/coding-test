import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i = 97; i <= 122; i++){
            char c = (char) i;
            System.out.print(str.indexOf(c)+" ");
        }
    }
}