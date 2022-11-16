import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static int solution(int N, int K){
       int answer = 0;
       Queue<Integer> queue = new LinkedList<>();
       for(int i=1; i<=N; i++) queue.add(i);

       while(!queue.isEmpty()){
           for(int i=1; i<K; i++) queue.offer(queue.poll()); //k-1까지 뒤로 이동, k번째는 poll
           queue.poll();
           if(queue.size() == 1) answer = queue.poll(); //queue size가 1개일 경우 return
       }
       return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        System.out.println(solution(N, K));
    }
}


/*
N = 8, K = 3
1. queue를 1~N으로 초기화를 해준다.
2. queue에 아무것도 없을때까지 반복한다.
   k-1만큼 반복문을 돌면서 k번째 오는 왕자를 제거
        -> 1 2 3 4 5 6 7 8 (K번째 3)
        -> 4 5 6 7 8 1 2 (K번째 6)
        -> 7 8 1 2 4 5 (K번째 1)
        -> 2 4 5 7 8 (K번째 5)
        -> 7 8 2 4 (K번째 2)
        -> 4 7 8 (K번째 8)
        -> 4 7
        = queue는 FIFO 구조로 맨 앞의 7보다 먼저 입력된 4 제거
3. queue size가 1인경우 answer = queue.poll();
 */

