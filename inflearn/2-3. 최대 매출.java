//시간초과 O(n2)
import java.util.Scanner;

public class Main {
    static int solution(int[] sales, int k){
        int answer = 0;

        for(int i=0; i<sales.length; i++){
            int num = 0;
            if(i + k > sales.length){
                num += sales[i];
                num += sales[0];
                num += sales[1];
                break;
            }else{
                for(int j=i; j<i+k; j++){
                    num += sales[j];
                }
            }

            if(num > answer){
                answer = num;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] sales = new int[n];
        for(int i=0; i<n; i++){
            sales[i] = scan.nextInt();
        }

        System.out.println(solution(sales, k));
    }
}


//풀이 o(n)

import java.util.Scanner;

public class Main {
    static int solution(int n, int k, int[] arr){
        int answer = 0;
        int sum = 0;

        //첫 번째 window 초기화
        for(int i=0; i<k; i++) sum += arr[i];
        answer = sum;

        //한칸씩 우측으로 밀면서 값 비교하여 최대값 찾기
        for(int i=k; i<arr.length; i++){
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(sum, answer);
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }
}


