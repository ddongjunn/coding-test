import java.util.Scanner;

public class Main {

    static int solution(int n){
        int answer = 0;
        int cnt = 1;
        n--;    //15 - 1 = 14
        while(n>0){
            cnt++;
            n = n - cnt;    //14 - 2 = 12
            if(n % cnt == 0) answer++;
        }
        return answer;
    }
/*
n = 15 라고 가정
처음에 2개(최소 연속된 수) 각각 1, 2로 할당하여
n에서 1과 2를 뺀후 그 나머지 n 값으로 최소 연속된 수로 나눴을때 나머지가 0 이면 answer++;

n % cnt == 0 조건이 만족하게 되면, 연속된 수에 값을 정확하게 나눌 수 있다.
n = 12
1 2
6 6
-> 7 + 8

n = 9
1 2 3
3 3 3
-> 4 + 5 + 6

n = 5
1 2 3 4
-> 나머지 1 발생
X

n = 0
1 2 3 4 5
0 0 0 0 0
-> 1 + 2 + 3 + 4 + 5
 */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(solution(n));
    }
}
