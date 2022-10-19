import java.util.Scanner;

public class Main {

    public void solution(int[] score){
        int answer[] = new int[score.length];

        for(int i=0; i<score.length; i++){
            int cnt = 1;
            for(int j=0; j<score.length; j++){
                if(score[i] < score[j]){
                    cnt++;
                }
            }
            answer[i] = cnt;
            cnt = 1;
        }

        for ( int i : answer) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int score[] = new int[N];
        for(int i=0; i<N; i++){
            score[i] = scan.nextInt();
        }

        Main main = new Main();
        main.solution(score);
    }
}
