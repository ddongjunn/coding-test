package hello.core.member;

import java.util.Scanner;

public class Main {
    static int solution(int n){
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int length = n / 2 + 1;
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i] = i + 1;
        }

        for(int rt=0; rt<length; rt++){
            sum += arr[rt];
            if(sum == n){
                answer++;
            }
            while(sum >= n){
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(solution(n));
    }
}

/*
연속된 자연수 조건
N / 2 = 몫 + 1
    -> N = 15일때, 8 + 9은 15가 넘어가기 때문에 연속된 자연수 조건에서 벗어난다


 */
