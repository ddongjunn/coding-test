import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        Stack<int []> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek()[0] < num){ //가장 앞의 탑이 n보다 작으면, 앞으로 어떠한 신호도 수신할 수 없으므로 스택에서 제거
                    stack.pop();
                }else{//num보다 크다면, 해당 탑의 번호를 출력
                    sb.append(stack.peek()[1] + " ");
                    break;
                }
            }

            if(stack.empty()){
                sb.append("0 ");
            }
            stack.push(new int[] {num, i+1});// 탑의 높이, 탑의 번호
        }
        System.out.println(sb.toString());
    }
}
