import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();

        if( y >= 45 ){
            System.out.print(x);
            System.out.print("\n");
            System.out.print(y-45);
        }else if( y < 45){
            if(x == 0){
                System.out.print("23");
                System.out.print("\n");
                System.out.print(60-(45-y));
                return;
            }
            System.out.print(x-1);
            System.out.print("\n");
            System.out.print(60-(45-y));
        }
    }
}
