import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int answer = scan.nextInt();

        for(int i=1; i<10; i++){
            System.out.println(answer + " * " + i + " = " + answer*i);
        }
    }
}
