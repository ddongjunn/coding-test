
import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer = "YES";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String temp = new StringBuilder(str).reverse().toString();
        if(!str.equals(temp)) answer = "NO";
        return answer;
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(main.solution(str));
    }
}
