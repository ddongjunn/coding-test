import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String temp = "";
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");

            int cycle = Integer.parseInt(st.nextToken());
            String strs = st.nextToken();
            for(int j = 0; j < strs.length(); j++){
                for(int x = 0; x < cycle; x++){
                    temp += strs.charAt(j) + "";
                }
            }
            System.out.println(temp);
            temp = "";
        }
    }
}