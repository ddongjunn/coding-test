import java.util.Scanner;

public class Main {
    public int[] solution(int N){
        int answer[] = new int[N];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i < N; i++){
            answer[i] = answer[i-1] + answer[i-2];
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        int N = scan.nextInt();
        for(int x : main.solution(N)){
            System.out.print(x + " ");
        }
    }
}

////////////////////////////////////////////////

import java.util.Scanner;

public class Main {
    public void solution(int N){
        int x = 1;
        int y = 1;
        int z;
        System.out.print(x + " " + y + " ");
        for(int i=2; i<N; i++){
            z = x + y;
            System.out.print(z + " ");
            x = y;
            y = z;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        int N = scan.nextInt();
        main.solution(N);
    }

}
