import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static int solution(String str){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char x = str.charAt(i);
            if(x == '('){
                stack.push(x);
            }else{ // ')' 일 경우 레이저인지, 쇠막대기인지 확인해야함
                if(str.charAt(i-1) == '('){ //레이저인 경우 레이저의 여는괄호를 제거해주고, stack의 size만큼(쇠 막대기 조각)추가
                    stack.pop();
                    answer += stack.size();
                }else{//쇠막대기인 경우 열린괄호를 제거하고, 1조각 추가
                    stack.pop();
                    answer += 1;
                }
            }
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
()(((()())(())()))(())

'('는 stack push
')'를 만난경우 쇠 막대기의 끝인지, 레이저인지 알아내야 한다.
    if 바로 앞의 값을 확인해서 '('이면 레이저
        레이저의 시작 '(' stack.pop()을 해준다.
        answer += stack.size() // stack에 남아있는 '('는 막대기다.
    else //막대기의 끝
        막대기의 여는괄호 '('를 pop() 시켜주고
        answer를 하나 추가

    answer += stack.size()


 */
