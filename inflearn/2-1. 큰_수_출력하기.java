import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int N, String[] num){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(Integer.parseInt(num[0]));

        for(int i = 1; i < num.length; i++){
            if(Integer.parseInt(num[i]) > Integer.parseInt(num[i-1])){
                answer.add(Integer.parseInt(num[i]));
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        String[] num = new String[N];
        for(int i = 0; i < num.length; i++){
            num[i] = scan.next();
        }
        for(int i : main.solution(N, num)){
            System.out.print(i + " ");
        }
    }
}


/////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int N, int[] num){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(num[0]);
        
        for(int i = 1; i < N; i++){
            if(num[i] > num[i-1]){
                answer.add(num[i]);
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
        for(int x : main.solution(N, num)){
            System.out.print(x + " ");
        }
    }
}
