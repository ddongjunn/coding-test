import java.util.Scanner;

public class Main {
    public int solution(int N){
        int answer = 0;
        int[] chk = new int[N+1]; //N index까지
        for(int i=2; i<=N; i++){
            if(chk[i]==0){
                answer++;
                for(int j=i; j<=N; j=j+1){
                    chk[j]=1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        int N = scan.nextInt();
        System.out.println(main.solution(N));
    }

}
