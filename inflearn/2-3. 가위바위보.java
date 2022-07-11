package hello.core.order;

import java.util.Scanner;

public class Main {
    public String[] solution(int N, String[] A, String[] B){
        String[] answer = new String[N];

        for(int i = 0; i < N; i++){
            if(A[i].equals(B[i])){
                answer[i] = "D";
            } else if(A[i].equals("1") && B[i].equals("3")){
                answer[i] = "A";
            } else if(A[i].equals("2") && B[i].equals("1")){
                answer[i] = "A";
            } else if (A[i].equals("3") && B[i].equals("2")){
                answer[i] = "A";
            } else {
                answer[i] = "B";
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        String[] A = new String[N];
        for(int i = 0; i < N; i++){
            A[i] = scan.next();
        }

        String[] B = new String[N];
        for(int i = 0; i < N; i++){
            B[i] = scan.next();
        }

        Main main = new Main();
        for(String s : main.solution(N, A, B)){
            System.out.println(s);
        }
    }

}
