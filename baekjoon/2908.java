import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int num1 = changeNum(st.nextToken());
        int num2 = changeNum(st.nextToken());

        System.out.println(Math.max(num1, num2));

    }

    public static int changeNum(String strNum){
        StringBuffer sb = new StringBuffer();
        sb.append(strNum.substring(2));
        sb.append(strNum.substring(1,2));
        sb.append(strNum.substring(0,1));

        return Integer.parseInt(sb.toString());
    }

}