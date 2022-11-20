import java.util.*;

public class Main {
    static int solution(String posfix){
        Stack<String> stack = new Stack<>();
        for(char x : posfix.toCharArray()){
            if(x == '+' || x == '-' || x == '*' || x == '/'){
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                switch(x){
                    case '+' : stack.push(String.valueOf(first + second)); break;
                    case '-' : stack.push(String.valueOf(first - second)); break;
                    case '*' : stack.push(String.valueOf(first * second)); break;
                    case '/' : stack.push(String.valueOf(first / second)); break;
                }
            }else{
                stack.push(String.valueOf(x));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String postfix = scan.next();
        System.out.println(solution(postfix));
    }
}

/*
풀이

static int solution(String posfix){
    Stack<Integer> stack = new Stack<>();
    for(char x : posfix.toCharArray()){
        if(Character.isDigit(x)){ //숫자인지 판별
            stack.push(x-48); //char형 '0'은 48
        }else{
            int second = stack.pop();
            int first = stack.pop();
            if(x == '+') stack.push(first+second);
            else if(x == '-') stack.push(first-second);
            else if(x == '*') stack.push(first*second);
            else stack.push(first/second);
        }
    }
    return stack.pop();
}
  
 ㄱ. Character.isDigit()으로 숫자인지 아닌지 판별
 ㄴ. 피연산자(숫자)이면 stack에 넣어주고
 ㄷ. 연산자면 stack에서 2개의 숫자를 꺼내서 연산
     (숫자의 위치는 변하지 않고, stack는 LIFO구조로 처음에 꺼낸 숫자가 두번째 숫자 즉, first op second)
 ㄹ. ㄷ.에서 연산한 숫자를 stack.push()
 ㅁ. 마지막 스택에 남아있는 값 stack.pop()
    
*/
