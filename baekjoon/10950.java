import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int answer = scan.nextInt();
        
        for(int i=0; i<answer; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(x+y);
        }

        
    }
}
