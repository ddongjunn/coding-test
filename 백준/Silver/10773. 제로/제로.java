import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<K; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0) stack.pop();
            else stack.push(x);
        }

        int x = stack.stream().mapToInt(Integer::intValue).sum();
        System.out.println(x);
    }
}
