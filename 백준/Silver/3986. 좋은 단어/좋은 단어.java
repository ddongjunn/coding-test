import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    static int count = 0;
    static void solution(String word){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<word.length(); i++){
            if(!stack.isEmpty() && stack.peek() == word.charAt(i)){
                stack.pop();
            }else{
                stack.push(word.charAt(i));
            }
        }
        if(stack.isEmpty()) count++;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            solution(br.readLine());
        }
        System.out.println(count);
    }
}
