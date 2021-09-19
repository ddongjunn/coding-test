import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = Integer.parseInt(br.readLine());

        for(int i=0; i<answer; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write("Case #" + (i+1) + ": " + x + " + " + y + " = " );
            bw.write((x+y) + "\n");
            bw.flush();
        }

        bw.close();
    }
}
