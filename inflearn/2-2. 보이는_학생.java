import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int solution(int N, int[] num){
        int answer = 0;
        int tmp = Integer.MIN_VALUE;
        for(int i : num){
            if(tmp < i){
                tmp = i;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        int[] num = new int[N];
        for(int i = 0; i < N; i++){
            num[i] = scan.nextInt();
        }
        System.out.println(main.solution(N,num));
    }
}

//////////////////////////////////////////
