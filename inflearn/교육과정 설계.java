import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static String solution(String need, String plan){
        String answer = "NO";
        Queue<Character> q = new LinkedList<>();
        for(char x : need.toCharArray()) q.offer(x);
        for(char x : plan.toCharArray()){
            if(q.peek() == x) q.poll();
            if(q.isEmpty()) return "YES";
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String need = scan.next();
        String plan = scan.next();
        System.out.println(solution(need, plan));
    }
}
/*
queue의 구조(FIFO)만 알면 쉽게 풀수있는문제이다.

필수과목을 queue에 순서대로 넣어준다.
수업계획을 순차적으로 탐색하면서 queue제일 맨위에 있는 값과 확인하여, 값이 같다면 queue에서 제거
queue에 값이 없으면 조건 성립 return "YES"

다른풀이
public static String solution(String need, String plan){
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for(char x : need.toCharArray()) q.offer(x);
        for(char x : plan.toCharArray()){
            if(q.contains(x)){
                if(x!=q.poll()) return "NO";
            }
        }
        if(!q.isEmpty()) return "NO";
        return answer;
    }
 */

