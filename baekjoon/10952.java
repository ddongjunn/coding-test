import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            int x = scan.nextInt();
            int y = scan.nextInt();
            
            if(x + y == 0){
                break;
            }
            
            System.out.println(x+y);
        }
    }
}
