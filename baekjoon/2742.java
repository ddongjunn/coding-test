import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = Integer.parseInt(br.readLine());

        for(int i=answer; i>0; i--){
            bw.write(i+"\n");
        }

        bw.close();
    }
}
