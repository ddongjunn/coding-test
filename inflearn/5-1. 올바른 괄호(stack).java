import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static String solution(String str){
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '(') stack.push(ch);
            else{
                if(stack.isEmpty()){
                    return "NO";
                }else{
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()) return "NO"; //stack자료가 남아있으면 거짓 -> ')'가 많은 상황

        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(solution(str));
    }
}
