import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String bar = br.readLine();
       Stack<Character> stack = new Stack<>();

       int answer = 0;
       for(int i=0; i<bar.length(); i++){
            char ch = bar.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }else{
                if(bar.charAt(i - 1) == '('){
                    stack.pop();
                    answer += stack.size();
                }else{
                    stack.pop();
                    answer++;
                }
            }
       }
       System.out.println(answer);
    }
}