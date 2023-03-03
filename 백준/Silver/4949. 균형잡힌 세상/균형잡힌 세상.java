import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static String solution(String word){
        Stack<Character> stack = new Stack<>();
        for(char c : word.toCharArray()){
            if(c == '(' || c == '['){
                stack.push(c);
            }else if( c == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    return "no";
                }else{
                    stack.pop();
                }
            }else if( c == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    return "no";
                }else{
                    stack.pop();
                }
            }
        }

        if(stack.empty()){
            return "yes";
        }
        return "no";
    }
    public static void main(String[] args) throws Exception {
        Stack<Character> stack;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String word = br.readLine();
            
            if(word.equals(".")){
                break;
            }
            
            System.out.println(solution(word));
        }
    }
}
