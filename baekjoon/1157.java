import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();

        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++){
            count[(str.charAt(i) - 97)]++;
        }

        int max = -1;
        char ch = '?';
        for(int i = 0; i < count.length; i++){
            if(count[i] > max){
                max = count[i];
                ch = (char) (i + 65);
            }else if(count[i] == max){
                ch = '?';
            }
        }

        System.out.println(ch);

    }
}