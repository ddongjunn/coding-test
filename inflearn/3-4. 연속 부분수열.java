package hello.core.member;

import java.util.Scanner;

public class Main {
    static int solution(int n, int m, int[] arr){
        int answer = 0;
        int lt = 0;
        int sum = 0;
        for(int rt=0; rt<n; rt++){  //증가
            sum += arr[rt]; //더하기
            if(sum == m) answer++;  //확인
            while(sum >= m){
                sum -= arr[lt++];   //arr[lt]빼고 lt값 증가
                if(sum == m) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }
}

/*
lt 부터 rt 까지 연속된 합 확인
1. int sum = lt부터 rt까지 연속수열 합
2.    if(sum == m) 확인

3. rt 증가
4. sum += rt 증가한 rt 값 누적
5. if(sum == m) 확인

6. sum 이 m 보다 작으면 다시 rt 증가

7. sum이 m값 보다 크면 lt값 증가하면서 sum - arr[lt]빼기
8. if(sum == m) 확인

9. sum == m lt값 증가하면서 sum - arr[lt]


sum이 m 보다 작으면 rt는 sum에 arr[rt]를 더하고 확인

 */
