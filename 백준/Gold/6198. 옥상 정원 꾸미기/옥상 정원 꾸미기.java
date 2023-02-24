import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
    
        long cnt = 0;
        for(int i=0; i<N; i++){
            int h = Integer.parseInt(br.readLine());
            
            while(!stack.isEmpty() && stack.peek() <= h){
                stack.pop();
            }

            cnt += stack.size();
            stack.push(h);
        }
        System.out.println(cnt);
    }
}
