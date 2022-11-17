import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static int solution(int N, int M, int[] arr){
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for(int i=0; i<N; i++) q.offer(new Person(i, arr[i])); //우선순위, 위험도를 하나의 객체로 만들어서 queue에 넣는다.
        while(!q.isEmpty()){
            Person tmp = q.poll();
            for(Person person : q){
                if(person.priority > tmp.priority){
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp!=null){
                answer++;
                if(tmp.id == M) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = scan.nextInt();
        System.out.println(solution(N, M, arr));
    }
}

class Person{
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

/*
우선순위(id), 위험도(priority)를 하나의 객체로 만들어서 queue에 넣는다.
queue.poll()로 제일 앞에있는 Person의 객체(tmp)로 queue 에담겨있는 환자들의 위험도와 비교
    -> queue의 위험도가 더 높은경우 tmp를 다시 queue에 넣어주고, tmp를 null로 변경
tmp가 null이 아니면(진료를 받는경우) answer를 증가
    -> tmp.id가 M번째 환자인 경우 함수 종료
 */
