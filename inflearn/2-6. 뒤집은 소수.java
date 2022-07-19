import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public boolean isPrime(int num){
        if(num == 1){
            return false;
        }

        for(int i=2; i<num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public ArrayList<Integer> solution (int N, int[] num){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<N; i++){
            int tmp = num[i];
            int result= 0;
            while(tmp > 0){
                int t = tmp % 10;
                result = result * 10 + t;
                tmp = tmp / 10;
            }
            if(isPrime(result)){
                answer.add(result);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        int N = scan.nextInt();
        int[] num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = scan.nextInt();
        }
        for(int x : main.solution(N, num)){
            System.out.print(x + " ");
        }
    }

}
