import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static String solution(String str){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == ')'){//')'를 만나면 '('까지 stack에서 제거
                while(stack.pop() != '(');
            }else{
                stack.push(ch);
            }
        }
        for(char ch : stack){
            answer += ch;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(solution(str));
    }
}

/*
stack 사용안하고 푼 경우
import java.util.Scanner;

public class Main{
    public static String solution(String str){
        String answer = "";
        int cnt = 0;
        for(char ch : str.toCharArray()){
            if(ch == '(') cnt++;
            else if (ch == ')') cnt--;
            if(cnt == 0 && ch != ')') answer += ch;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(solution(str));
    }
}
 */



