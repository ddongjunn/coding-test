import java.util.Scanner;

public class Main {

    static int solution(int n, int m , int[] arr){
        int answer = 0;
        int sum = 0;
        int lt = 0;
        for(int rt=0; rt<n; rt++){
            sum += arr[rt];
            if(sum == m) answer++; //lt ~ rt 합
            while(sum >= m){
                sum -= arr[lt++];   //arr[lt]값 빼고 lt값 증가
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
