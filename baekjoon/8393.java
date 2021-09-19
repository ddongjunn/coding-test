import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int answer = scan.nextInt();

        int result = 0;
        for(int i=0; i<=answer; i++){
            result += i;
        }
        System.out.println(result);


    }
}
