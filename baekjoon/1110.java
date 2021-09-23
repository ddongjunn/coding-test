import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int result = num;
        int count = 0;

        while(true){
            num = ((num % 10) * 10) + (((num / 10) + (num % 10)) % 10);
            count++;

            if(result == num){
                break;
            }
        }

        System.out.println(count);
    }
}
