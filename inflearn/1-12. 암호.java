import java.util.Scanner;

public class Main {
    public String solution (int n, String str){
        String answer = "";
        for(int i = 0; i < n; i++){
            String temp = str.substring(0, 7).replace("#","1").replace("*","0");
            answer += (char) Integer.parseInt(temp, 2);
            str = str.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String str = scan.next();
        System.out.println(main.solution(n, str));
    }
}
